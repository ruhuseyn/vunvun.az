package com.example.rentacarmain.dtos.request;

import jakarta.validation.constraints.NotNull;


public record ModelRequest(
        @NotNull(message = "Id is mandatory")
        Long id
) {
}
