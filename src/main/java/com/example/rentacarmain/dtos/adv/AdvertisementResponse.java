package com.example.rentacarmain.dtos.adv;

import com.example.rentacarmain.dtos.location.LocationRequest;
import com.example.rentacarmain.dtos.model.ModelRequest;
import com.example.rentacarmain.dtos.owner.OwnerRequest;

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
