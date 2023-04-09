package com.example.rentacarmain.dtos.adv;

import com.example.rentacarmain.dtos.brand.BrandDTO;
import com.example.rentacarmain.dtos.location.LocationResponse;
import com.example.rentacarmain.dtos.model.ModelResponse;
import com.example.rentacarmain.dtos.owner.OwnerResponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record DetailedAdvResponse(
        String description,
        BigDecimal price,
        LocalDate creationTime,
        OwnerResponse owner,
        ModelResponse model,
        LocationResponse location,
        BrandDTO brand
) {
}
