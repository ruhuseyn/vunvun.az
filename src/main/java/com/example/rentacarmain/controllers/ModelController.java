package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.model.AddModelRequest;
import com.example.rentacarmain.dtos.model.ModelRequest;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.mappers.AllStructuredMapper;
import com.example.rentacarmain.repositories.ModelRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
public record ModelController(
        ModelRepository repository,
        AllStructuredMapper mapper) {

    @GetMapping
    public List<Model> getAll(@RequestParam(value = "brand_id",required = false) Long brandId){

        if (brandId != null){
            return repository.findAllByBrand_Id(brandId);
        }

        return repository.findAll();
    }

    @PostMapping
    public void add(@Valid @RequestBody AddModelRequest request){
        repository.save(mapper.addModelRequestToModel(request));

    }
}
