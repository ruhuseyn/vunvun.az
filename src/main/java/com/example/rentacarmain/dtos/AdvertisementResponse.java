package com.example.rentacarmain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AdvertisementResponse(
        String description,
        BigDecimal price,
        LocalDate creationTime,
        String motorVolume,
        ModelRequest model,
        OwnerRequest owner,
        LocationRequest location
) {
}
