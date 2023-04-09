package com.example.rentacarmain.dtos.user;

public record UserResponse(

        String email,

        Double budget,

        String firstName,

        String lastName

) {
}
