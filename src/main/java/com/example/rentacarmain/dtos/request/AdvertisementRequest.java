package com.example.rentacarmain.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AdvertisementRequest(
        @NotBlank(message = "Description is mandatory")
        @NotNull
        @NotEmpty
        String description,
        @NotNull(message = "Price is mandatory")
        BigDecimal price,
        @NotNull(message = "Creationtime is mandatory")
        LocalDate creationTime,
        @NotBlank(message = "Motorvolume is mandatory")
        @NotNull
        @NotEmpty
        String motorVolume,
        @NotNull(message = "Model is mandatory")
        ModelRequest model,
        @NotNull(message = "Owner is mandatory")
        OwnerRequest owner,
        @NotNull(message = "Location is mandatory")
        LocationRequest location) {

}
