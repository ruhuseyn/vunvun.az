package com.example.rentacarmain.controller;

import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.repositories.ModelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/models")
public record ModelController(ModelRepository repository) {

    @GetMapping
    public List<Model> getAll(@RequestParam(value = "brand_id",required = false) Long brandId){

        if (brandId != null){
            return repository.findAllByBrand_Id(brandId);
        }

        return repository.findAll();
    }

}
