package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.brand.BrandRequest;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.mappers.AllStructuredMapper;
import com.example.rentacarmain.repositories.BrandRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@CrossOrigin(origins = "*")
public record BrandController(
        BrandRepository repository,
        AllStructuredMapper mapper) {

    @GetMapping
    public List<Brand> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable(name = "id")  Long id ){
        return repository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@Valid @RequestBody BrandRequest brand){
        repository.save(mapper.brandRequestToBrand(brand));
    }

}
