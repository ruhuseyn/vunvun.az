package com.example.rentacarmain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Builder
public record AllAdvResponse(
        Long id,

        String title,

        BigDecimal price
        ) {


}
