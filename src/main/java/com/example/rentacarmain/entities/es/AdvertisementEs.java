package com.example.rentacarmain.entities.es;

import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.entities.advertisement.CarDetails;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

//@Entity(name = "advertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "advertisement")
public class AdvertisementEs {

//    @Id
    Long id;

    CarDetails carDetails;

//    @Column(name = "discount")
    Double discount;

//    @Column(name = "daily_payment")
    Double dailyPayment;

//    @Column(name = "additional_details")
    String additionalDetails;

//    @ManyToOne
//    @JoinColumn(name = "owner_id")
    Owners owner;



}
