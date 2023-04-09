package com.example.rentacarmain.entities.advertisement;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity(name = "location")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Location {

    @Id
    @SequenceGenerator(
            name = "location_id_seq",
            sequenceName = "location_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "location_id_seq")
    Long id;

    @Column(name = "location_name")
    String name;

}
