package com.example.rentacarmain.entities.advertisement;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.Objects;

@Entity(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Images {


    @Id
    @SequenceGenerator(
            name = "images_id_seq",
            sequenceName = "images_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "images_id_seq")
    Long id;

    @Column(name = "image_data")
    byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    Advertisements advertisement;

}
