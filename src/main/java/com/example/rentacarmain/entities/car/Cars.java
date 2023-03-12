package com.example.rentacarmain.entities.car;

import com.example.rentacarmain.entities.Location;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


import java.util.List;

@Entity(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    Location location;

    @OneToMany
    @JoinColumn(name = "car_lists")
    List<CarList> carList;


}
