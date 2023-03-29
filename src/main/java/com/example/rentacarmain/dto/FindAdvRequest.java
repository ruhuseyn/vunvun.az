package com.example.rentacarmain.dto;

import org.springframework.web.bind.annotation.RequestParam;

public record FindAdvRequest(
        Long brandId,
        Long locationId,
        Long modelId
) {
}
