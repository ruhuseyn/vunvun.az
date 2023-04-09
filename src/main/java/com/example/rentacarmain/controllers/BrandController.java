package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.brand.BrandDTO;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.services.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@CrossOrigin(origins = "*")
public record BrandController(
        BrandService service) {

    @GetMapping
    public List<Brand> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BrandDTO getById(@PathVariable(name = "id")  Long id ){
        return service.getById(id);
    }



}
