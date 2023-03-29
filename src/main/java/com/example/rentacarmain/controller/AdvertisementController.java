package com.example.rentacarmain.controller;

import com.example.rentacarmain.dto.AdvertisementRequest;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.managers.AdvertisementManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advertisement")
public record AdvertisementController(AdvertisementManager manager) {


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addAdv(@RequestBody AdvertisementRequest request){
        manager.addAdvertisement(request);
        return "Ugurla elave edildi";
    }


}
