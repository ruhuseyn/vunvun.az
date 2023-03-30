package com.example.rentacarmain.dtos;

import jakarta.validation.constraints.NotBlank;

public record FindAdvRequest(
        Long brandId,
        Long locationId,
        Long modelId
) {
}
