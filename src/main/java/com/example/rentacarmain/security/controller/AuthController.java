package com.example.rentacarmain.security.controller;

import com.example.rentacarmain.security.dto.AuthenticationRequest;
import com.example.rentacarmain.security.dto.AuthenticationResponse;
import com.example.rentacarmain.security.dto.RegisterRequest;
import com.example.rentacarmain.security.dto.RegistrationResponse;
import com.example.rentacarmain.security.service.AuthenticationService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public record AuthController(AuthenticationService service) {


    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody @Valid RegisterRequest request) throws MessagingException, UnsupportedEncodingException {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam(name = "email")@Valid String email, @RequestParam(name = "code") String code){
        service.verify(email,code);
        return ResponseEntity.ok("Your account successfully verified.");
    }
}
