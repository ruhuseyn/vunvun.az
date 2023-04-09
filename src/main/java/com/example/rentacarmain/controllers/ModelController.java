package com.example.rentacarmain.controllers;

import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.services.ModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
public record ModelController(
        ModelService service
) {

    @GetMapping
    public List<Model> getAll(@RequestParam(value = "brand_id",required = false) Long brandId){

        if (brandId != null){
            return service.getAllByBrandId(brandId);
        }

        return service.getAll();
    }

}
