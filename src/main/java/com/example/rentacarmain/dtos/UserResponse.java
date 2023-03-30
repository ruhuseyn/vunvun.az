package com.example.rentacarmain.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserResponse(

        String email,

        Double budget,

        String firstName,

        String lastName

) {
}
