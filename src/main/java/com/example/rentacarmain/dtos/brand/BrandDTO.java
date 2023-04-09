package com.example.rentacarmain.dtos.brand;

import jakarta.validation.constraints.NotBlank;

public record BrandDTO(
        @NotBlank(message = "Brand name should not be empty")
        String name) {
}
