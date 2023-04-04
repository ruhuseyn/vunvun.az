package com.example.rentacarmain.dtos.response;

import lombok.*;

import java.math.BigDecimal;

@Builder
public record AllAdvResponse(
        Long id,

        String title,

        BigDecimal price
        ) {


}
