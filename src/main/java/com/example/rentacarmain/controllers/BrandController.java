package com.example.rentacarmain.controllers;

import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.repositories.BrandRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@CrossOrigin(origins = "*")
public record BrandController(BrandRepository repository) {

    @GetMapping
    public List<Brand> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable(name = "id")  Long id ){
        return repository.findById(id).get();
    }

    @PostMapping
    public void add(@Valid @RequestBody Brand brand){
        repository.save(brand);
    }

}
