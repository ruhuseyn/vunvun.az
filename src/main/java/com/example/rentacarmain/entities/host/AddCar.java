package com.example.rentacarmain.entities.host;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "add_car")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "image")
    Byte[] hostImage;

    @Column(name = "location")
    String location;

    @Column(name = "phone_number")
    String phoneNumber;

    @OneToMany
    @JoinColumn(name = "cardetails_id")
    List<CarDetails> carDetails;
}
