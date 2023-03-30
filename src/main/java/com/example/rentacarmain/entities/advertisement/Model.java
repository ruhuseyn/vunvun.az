package com.example.rentacarmain.entities.advertisement;

import com.example.rentacarmain.entities.Reviews;
import com.example.rentacarmain.entities.advertisement.Brand;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity(name = "model")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Model {

    @Id
    @SequenceGenerator(
            name = "model_id_seq",
            sequenceName = "model_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "model_id_seq")
    Long id;

    @Column(name = "brand")
    String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;

    @OneToMany
    @JoinColumn(name = "review_id")
    List<Reviews> reviews;
}
