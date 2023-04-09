package com.example.rentacarmain.dtos.location;

import jakarta.validation.constraints.NotNull;

public record AdvertisementLocationRequest(
        @NotNull(message = "Location id bosh olmamalidir")
        Long id
) {
}
