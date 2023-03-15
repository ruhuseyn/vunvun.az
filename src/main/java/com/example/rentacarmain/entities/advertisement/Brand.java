package com.example.rentacarmain.entities.advertisement;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity(name = "brands")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Brand {
    @Id
    @SequenceGenerator(
            name = "brand_id_seq",
            sequenceName = "brand_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brand_id_seq")
    Long id;

    @Column(name = "brand")
    String name;


}