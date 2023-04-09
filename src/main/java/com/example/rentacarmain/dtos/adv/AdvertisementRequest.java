package com.example.rentacarmain.dtos.adv;

import com.example.rentacarmain.dtos.location.LocationRequest;
import com.example.rentacarmain.dtos.model.ModelRequest;
import com.example.rentacarmain.dtos.owner.OwnerRequest;
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
        @NotNull(message = "Model is mandatory")
        ModelRequest model,
        @NotNull(message = "Owner is mandatory")
        OwnerRequest owner,
        @NotNull(message = "Location is mandatory")
        LocationRequest location) {

}
