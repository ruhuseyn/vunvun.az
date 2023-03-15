package com.example.rentacarmain.entities.es;

import com.example.rentacarmain.entities.Owners;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "elastic_search")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "elasticsearch")
public class AdvertisementEs {

    @Id
    Long id;

    @Column(name = "title")
    String title;

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

    @Column(name = "owner_id")
    Long owner_id;

}
