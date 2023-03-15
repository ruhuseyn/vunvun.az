package com.example.rentacarmain.entities.advertisement;

import jakarta.persistence.*;
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
    @SequenceGenerator(
            name = "details_id_seq",
            sequenceName = "details_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "details_id_seq")
    Long id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    Model model;


    @Column(name = "creation_time")
    LocalDate creationTime;

    @Column(name = "motor_volume")
    String motorVolume;

}
