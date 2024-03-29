package com.example.rentacarmain.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OwnerRequest(
        @NotNull(message = "Id is mandatory")
        Long id) {
}
