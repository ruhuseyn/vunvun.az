package com.example.rentacarmain.entities.advertisement;

import com.example.rentacarmain.entities.advertisement.Brand;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity(name = "models")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Model {

    @Id
    @SequenceGenerator(
            name = "model_id_seq",
            sequenceName = "model_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "model_id_seq")
    Long id;

    @Column(name = "brand")
    String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;
}
