package com.example.rentacarmain.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LocationRequest(
        @NotNull(message = "Id is mandatory")
        Long id
) {
}
