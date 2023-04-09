package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.brand.BrandDTO;
import com.example.rentacarmain.entities.advertisement.Brand;

import java.util.List;

public interface BrandService {

     List<Brand> getAll();

     BrandDTO getById(Long id);

     void add(BrandDTO brand);

     void deleteById(Long id);

}
