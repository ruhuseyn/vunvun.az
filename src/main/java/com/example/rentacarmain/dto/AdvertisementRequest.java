package com.example.rentacarmain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AdvertisementRequest(String description,
                                   BigDecimal price,
                                   LocalDate creationTime,
                                   String motorVolume,
                                  ModelRequest model,
                                   OwnerRequest owner,
                                   LocationRequest location) {

}
