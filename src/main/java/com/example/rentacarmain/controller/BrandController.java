package com.example.rentacarmain.controller;

import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.managers.BrandManager;
import com.example.rentacarmain.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public record BrandController(BrandManager brandManager) {


    @GetMapping
    public List<Brand> getAll(){
        return brandManager.getAll();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable(name = "id") Long id ){
        return brandManager.getById(id);
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandManager.addBrand(brand);
    }

}
