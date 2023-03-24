package com.example.rentacarmain.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record AuthenticationRequest(
        @NotNull(message = "Email daxil edin!")
        @NotBlank(message = "Email daxil edin!")
        @Email(message = "Email daxil edin!")
        String email,

        @NotNull(message = "sifre daxil edin")
        @NotBlank(message = "sifre daxil edin")
        String password)
{
}
