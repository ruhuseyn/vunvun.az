package com.example.rentacarmain.entities.advertisement;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity(name = "brand")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Brand {

    @Id
    @SequenceGenerator(
            name = "brand_id_seq",
            sequenceName = "brand_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brand_id_seq")
    Long id;

    @Column(name = "brand")
    @NotBlank
    String name;


}