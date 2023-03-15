package com.example.rentacarmain.entities.advertisement;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Entity(name = "features")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Features {

    @Id
    @SequenceGenerator(
            name = "features_id_seq",
            sequenceName = "features_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "features_id_seq")
    Long id;

    @Column(name = "title")
    String title;


}
