package com.example.rentacarmain.dtos;

import jakarta.validation.constraints.NotBlank;

public record OwnerRequest(
        @NotBlank(message = "Id is mandatory")
        Long id) {
}
