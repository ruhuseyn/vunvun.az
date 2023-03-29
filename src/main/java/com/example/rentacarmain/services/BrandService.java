package com.example.rentacarmain.services;

import com.example.rentacarmain.entities.advertisement.Brand;

import java.util.List;

public interface BrandService {

     List<Brand> getAll();

     Brand getById(Long id);

     void addBrand(Brand brand);

}
