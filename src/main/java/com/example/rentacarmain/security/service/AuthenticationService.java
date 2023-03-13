package com.example.rentacarmain.security.service;

import com.ruhuseyn.racauth.config.JwtService;
import com.ruhuseyn.racauth.dto.AuthenticationRequest;
import com.ruhuseyn.racauth.dto.AuthenticationResponse;
import com.ruhuseyn.racauth.dto.RegisterRequest;
import com.ruhuseyn.racauth.dto.RegistrationResponse;
import com.ruhuseyn.racauth.entity.Role;
import com.ruhuseyn.racauth.entity.User;
import com.ruhuseyn.racauth.entity.UserRedisHash;
import com.ruhuseyn.racauth.exception.ExpiredVerificationCodeException;
import com.ruhuseyn.racauth.exception.IncorrectVerificationCodeException;
import com.ruhuseyn.racauth.repository.UserRedisRepository;
import com.ruhuseyn.racauth.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public record AuthenticationService(CustomUserDetailsService authService,

                                    UserRepository repository,
                                    UserRedisRepository redisRepository,
                                    PasswordEncoder encoder,
                                    JwtService jwtService,
                                    AuthenticationManager manager,
                                    JavaMailSender mailSender) {


    static final String FROM_ADDRESS = "vega.pro853@gmail.com";

    public RegistrationResponse register(RegisterRequest request) throws MessagingException, UnsupportedEncodingException {
        var user = User
                .builder()
                .email(request.email())
                .password(encoder.encode(request.password()))
                .role(Role.USER)
                .active(false)
                .build();
        repository.save(user);

        String verificationCode = UUID.randomUUID().toString();
        UserRedisHash userRedisHash = UserRedisHash
                .builder()
                .email(user.getEmail())
                .verificationCode(verificationCode)
                .generatedDateTime(LocalDateTime.now())
                .build();
        redisRepository.save(userRedisHash);

        sendVerificationEmail(userRedisHash);

        return RegistrationResponse
                .builder()
                .message("Successfully added. Verification link has been sent to your email : " + request.email())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        var user = authService.loadUserByUsername(request.email());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void sendVerificationEmail(UserRedisHash user)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String senderName = "UKKU AZ";
        String subject = "Hesabınızı təsdiqləyin";
        String content = "Əziz istifadəçimiz, <br>"
                + "Təhlükəsizlik linkiniz:<br>"
                + "<a href=\"http://localhost:8080/auth/verify?email=[[email]]&code=[[verificationCode]]\"><br>Zəhmət olmasa klikləyin</a>"
                + "Təşşəkür edirik, "
                + senderName;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);


        helper.setFrom(FROM_ADDRESS, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);


        content = content.replace("[[email]]", user.getEmail());
        content = content.replace("[[verificationCode]]", user.getVerificationCode());

        helper.setText(content, true);

        mailSender.send(message);
    }

    public void verify(@NotBlank @Email String email, String code) {
        UserRedisHash redisHash = redisRepository.getById(email);
        if (redisHash == null || !redisHash.getVerificationCode().equals(code)) {
            throw new IncorrectVerificationCodeException("Verification code is incorrect!");
        } else if (!redisHash.getGeneratedDateTime().plusMinutes(15).isAfter(LocalDateTime.now())) {
            redisRepository.deleteById(redisHash.getEmail());
            repository.deleteUserByEmail(email);
            throw new ExpiredVerificationCodeException(
                    """
                    Verification code is expired.
                    Please register again!
                    """);
        }

        repository.activateByEmail(true,email);

    }
}
