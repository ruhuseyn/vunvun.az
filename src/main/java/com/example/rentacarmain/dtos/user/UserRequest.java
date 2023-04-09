package com.example.rentacarmain.dtos.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @Email
        String email,

        @Size(min = 8)
        String password,

        String firstName,

        String lastName
) {
}
