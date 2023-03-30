package com.example.rentacarmain.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AdvertisementRequest(
        @NotBlank(message = "Description is mandatory")
        String description,
        @NotBlank(message = "Price is mandatory")
        BigDecimal price,
        @NotBlank(message = "Creationtime is mandatory")
        LocalDate creationTime,
        @NotBlank(message = "Motorvolume is mandatory")
        String motorVolume,
        @NotBlank(message = "Model is mandatory")
        ModelRequest model,
        @NotBlank(message = "Owner is mandatory")
        OwnerRequest owner,
        @NotBlank(message = "Location is mandatory")
        LocationRequest location) {

}
