package com.example.rentacarmain.dto;

import jakarta.persistence.Column;

public record UserResponse(

         String email,


         Double budget,

         String firstName,

         String lastName

) {
}
