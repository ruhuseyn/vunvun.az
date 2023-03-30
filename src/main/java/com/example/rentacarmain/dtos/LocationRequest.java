package com.example.rentacarmain.dtos;

import jakarta.validation.constraints.NotBlank;

public record LocationRequest(
        @NotBlank(message = "Id is mandatory")
        Long id
) {
}
