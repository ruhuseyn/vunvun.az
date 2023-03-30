package com.example.rentacarmain.entities.image;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity(name = "image_adv")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageAdv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long advId;

    private String type;

    @Lob
    @Column(name = "image_data", length = 1000)
    private byte[] imageData;
}
