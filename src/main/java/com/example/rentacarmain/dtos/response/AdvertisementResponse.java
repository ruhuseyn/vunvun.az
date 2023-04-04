package com.example.rentacarmain.dtos.response;

import com.example.rentacarmain.dtos.request.LocationRequest;
import com.example.rentacarmain.dtos.request.ModelRequest;
import com.example.rentacarmain.dtos.request.OwnerRequest;

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
