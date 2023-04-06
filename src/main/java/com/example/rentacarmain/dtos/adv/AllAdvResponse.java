package com.example.rentacarmain.dtos.adv;

import lombok.*;

import java.math.BigDecimal;

@Builder
public record AllAdvResponse(
        Long id,

        String title,

        BigDecimal price
        ) {


}
