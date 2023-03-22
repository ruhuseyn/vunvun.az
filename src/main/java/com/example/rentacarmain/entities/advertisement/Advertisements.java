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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Advertisements {

    @Id
    @SequenceGenerator(
            name = "adv_id_seq",
            sequenceName = "adv_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "adv_id_seq")
    Long id;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "creation_time")
    LocalDate creationTime;

    @Column(name = "motor_volume")
    String motorVolume;

    @ManyToOne
    @JoinColumn(name = "model_id")
    Model model;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owners owner;

    //    @Column(name = "discount")
//    Double discount;
//    @Column(name = "daily_payment")
//    Double dailyPayment;
//
//    @Column(name = "additional_details")
//    String additionalDetails;
//
//    @OneToMany
//    @JoinColumn(name = "features_id")
//    List<Features> features;  WJLKFBKjfbsdhjfcbksdncjs hacvlwbcj;ASDBCLHJDSCVSVACBSJCBHDSHVCHSDGVAKJDS
//
//    @OneToMany
//    @JoinColumn(name = "reviews")
//    List<Reviews> reviews;


}
