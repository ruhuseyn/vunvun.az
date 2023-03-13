package com.example.rentacarmain.entities.advertisement;

import com.example.rentacarmain.entities.advertisement.Brand;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Model {

    @Id
    Long id;

    @Column(name = "brand")
    String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;
}
