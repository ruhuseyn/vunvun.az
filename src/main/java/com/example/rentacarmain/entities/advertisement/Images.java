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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "image_data")
    byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    Advertisements advertisement;

}
