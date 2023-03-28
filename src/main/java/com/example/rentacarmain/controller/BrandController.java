package com.example.rentacarmain.controller;

import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public record BrandController(BrandRepository repository) {

    @GetMapping
    public List<Brand> getAll(){
        return repository.findAll();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        repository.save(brand);
    }

}
