package com.example.rentacarmain.dtos.location;

import jakarta.validation.constraints.NotNull;

public record LocationRequest(
        @NotNull(message = "Id is mandatory")
        String name
) {
}
