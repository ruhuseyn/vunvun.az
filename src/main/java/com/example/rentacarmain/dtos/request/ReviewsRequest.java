package com.example.rentacarmain.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record ReviewsRequest(
        @NotBlank(message = "Id is mandatory")
        Long id) {
}
