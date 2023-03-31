package com.example.rentacarmain.dtos;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record DetailedAdvResponse(
        String description,
        BigDecimal price,
        LocalDate creationTime,
        String motorVolume,
        OwnerResponse owner,
        ModelResponse model,
        LocationResponse location,
        BrandResponse brand
) {
}
