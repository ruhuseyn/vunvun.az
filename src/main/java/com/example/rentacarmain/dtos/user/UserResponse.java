package com.example.rentacarmain.dtos.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record UserResponse(

        @Nullable
        String email,

        Double budget,

        String firstName,

        String lastName

) {
}
