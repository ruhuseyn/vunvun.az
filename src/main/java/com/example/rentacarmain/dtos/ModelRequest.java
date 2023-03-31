package com.example.rentacarmain.dtos;

import jakarta.validation.constraints.NotNull;


public record ModelRequest(
        @NotNull(message = "Id is mandatory")
        Long id
) {
}
