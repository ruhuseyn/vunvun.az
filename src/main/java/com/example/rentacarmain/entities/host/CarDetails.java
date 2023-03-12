package com.example.rentacarmain.entities.host;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity(name = "car_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarDetails {
    @Id
    Long id;

    @Column(name = "brand")
    String brand;

    @Column(name = "model")
    String model;

    @Column(name = "creation_time")
    LocalDate creationTime;

    @Column(name = "motor_volume")
    String motorVolume;

    @Column(name = "daily_payment")
    Double dailyPayment;

    @Column(name = "additional_details")
    String additionalDetails;
}
