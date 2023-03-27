package com.example.rentacarmain.security.controller;

import com.example.rentacarmain.security.dto.*;
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

    @PostMapping("/verify")
    public ResponseEntity<String> verify(@RequestBody VerificationRequest request){
        service.verify(request.email(),request.code());
        return ResponseEntity.ok("Hesabınız uğurla təsdiqləndi.");
    }
}
