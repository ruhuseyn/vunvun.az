package com.example.rentacarmain.entities.advertisement;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Brand {
    @Id
    Long id;

    @Column(name = "brand")
    String name;


}