package com.example.rentacarmain.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VerificationRequest(
        @NotNull(message = "Email daxil edin!")
        @NotBlank(message = "Email daxil edin!")
        @Email(message = "Email daxil edin!")
        String email,

        @NotNull(message = "code daxil edin")
        @NotBlank(message = "code daxil edin")
        String code) {

}
