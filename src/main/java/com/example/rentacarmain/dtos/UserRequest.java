package com.example.rentacarmain.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "Id is mandatory")
        Long id
) {
}
