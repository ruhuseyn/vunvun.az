package com.example.rentacarmain.security.service;

import com.example.rentacarmain.repositories.OwnerRepository;
import com.example.rentacarmain.security.config.JwtService;
import com.example.rentacarmain.security.dto.AuthenticationRequest;
import com.example.rentacarmain.security.dto.AuthenticationResponse;
import com.example.rentacarmain.security.dto.RegisterRequest;
import com.example.rentacarmain.security.dto.RegistrationResponse;
import com.example.rentacarmain.security.entity.Role;
import com.example.rentacarmain.security.entity.UserRedisHash;
import com.example.rentacarmain.entities.Users;
import com.example.rentacarmain.security.exception.EmailAlreadyTakenException;
import com.example.rentacarmain.security.exception.ExpiredVerificationCodeException;
import com.example.rentacarmain.security.exception.IncorrectVerificationCodeException;
import com.example.rentacarmain.security.repository.UserRedisRepository;
import com.example.rentacarmain.repositories.UserRepository;
import com.example.rentacarmain.services.OwnerService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AuthenticationService {
    private final CustomUserDetailsService authService;

    private final UserRepository repository;
    private final UserRedisRepository redisRepository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final JavaMailSender mailSender;

    private final OwnerRepository ownerRepository;


    static final String FROM_ADDRESS = "vega.pro853@gmail.com";

    public RegistrationResponse register(RegisterRequest request) throws MessagingException, UnsupportedEncodingException {

        if (repository.existsByEmail(request.email())) {
            throw new EmailAlreadyTakenException("Bu email ilə qeydiyyatdan keçilmişdir");
        }

        String verificationCode = UUID.randomUUID().toString();

        UserRedisHash userRedisHash = UserRedisHash
                .builder()
                .email(request.email())
                .verificationCode(verificationCode)
                .generatedDateTime(LocalDateTime.now())
                .password(encoder.encode(request.password()))
                .build();
        redisRepository.save(userRedisHash);

        sendVerificationEmail(request.email(), verificationCode);

        return RegistrationResponse
                .builder()
                .message("Təsdiqləmə kodu hesabınıza göndərildi : " + request.email())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        Long userId = repository.findUserByEmail(request.email()).get().getId();

        boolean isOwner = true;

        if (ownerRepository.findOwnersByUserId(userId).isEmpty()) {
            isOwner = false;
        }

        var user = authService.loadUserByUsername(request.email());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userId(userId)
                .token(jwtToken)
                .isOwner(isOwner)
                .build();
    }

    private void sendVerificationEmail(String email, String verificationCode)
            throws MessagingException, UnsupportedEncodingException {
        String senderName = "VUNVUN.az";
        String subject = "Hesabınızı təsdiqləyin";
        String content = "Əziz istifadəçimiz, <br>"
                + "Təsdiqləmə linkiniz:<br>"
                + "<a href=\"https://vunvun.live/verify?email=[[email]]&code=[[verificationCode]]\">Zəhmət olmasa klikləyin</a> <br>"
                + "Təşəkkür edirik,<br>"
                + senderName;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);


        helper.setFrom(FROM_ADDRESS, senderName);
        helper.setTo(email);
        helper.setSubject(subject);


        content = content.replace("[[email]]", email);
        content = content.replace("[[verificationCode]]", verificationCode);

        helper.setText(content, true);

        mailSender.send(message);
    }

    public void verify(String email, String code) {
        UserRedisHash redisHash = redisRepository.getById(email);
        if (redisHash == null || !redisHash.getVerificationCode().equals(code)) {
            throw new IncorrectVerificationCodeException("Təsdiqləmə kodu yanlışdır!");
        } else if (!redisHash.getGeneratedDateTime().plusMinutes(15).isAfter(LocalDateTime.now())) {
            redisRepository.deleteById(redisHash.getEmail());
            repository.deleteUserByEmail(email);
            throw new ExpiredVerificationCodeException(
                    """
                            Təsdiqləme kodu yanlışdır.
                            Zəhmət olmasa, qeydiyyatdan bir daha keçin!
                            """);
        }

        repository.save(
                Users.builder()
                        .active(true)
                        .role(Role.USER)
                        .email(redisHash.getEmail())
                        .password(redisHash.getPassword())
                        .build()
        );

        redisRepository.deleteById(email);

    }
}
