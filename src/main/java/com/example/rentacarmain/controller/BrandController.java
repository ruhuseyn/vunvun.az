package com.example.rentacarmain.controller;

import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.repositories.BrandRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
public record BrandController(BrandRepository repository) {

    @GetMapping
    public List<Brand> getAll(){
        return repository.findAll();
    }

}
