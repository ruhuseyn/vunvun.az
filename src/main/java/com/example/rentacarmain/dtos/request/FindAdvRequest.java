package com.example.rentacarmain.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record FindAdvRequest(
        Long brandId,
        Long locationId,
        Long modelId
) {
}
