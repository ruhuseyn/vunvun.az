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

    @Id
    @SequenceGenerator(
            name = "advertisement_id_seq",
            sequenceName = "advertisement_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "advertisement_id_seq")
    Long id;

    @OneToOne
    @JoinColumn(name = "details_id")
    CarDetails carDetails;

    @Column(name = "discount")
    Double discount;

    @Column(name = "daily_payment")
    Double dailyPayment;

    @Column(name = "additional_details")
    String additionalDetails;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owners owner;



}
