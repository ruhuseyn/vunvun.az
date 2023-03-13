package com.example.rentacarmain.entities.advertisement;

import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.entities.Reviews;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "advertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Advertisements {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(name = "description")
    String description;

    @Column(name = "discount")
    Double discount;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "creation_time")
    LocalDate creationTime;

    @Column(name = "motor_volume")
    String motorVolume;

    @Column(name = "daily_payment")
    Double dailyPayment;

    @Column(name = "additional_details")
    String additionalDetails;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owners owner;
//
//    @OneToMany
//    @JoinColumn(name = "features_id")
//    List<Features> features;
//
//    @OneToMany
//    @JoinColumn(name = "reviews")
//    List<Reviews> reviews;


}
