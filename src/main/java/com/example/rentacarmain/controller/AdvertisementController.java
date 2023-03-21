package com.example.rentacarmain.controller;

import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.managers.AdvertisementManager;
import com.example.rentacarmain.services.AdvertisementsService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/adv")
public record AdvertisementController(AdvertisementManager advertisementManager) {

    @GetMapping("/brand")
    public Advertisements getCarByBrand(@RequestParam Brand brand) {


        return advertisementManager.getCarByBrand(brand);
    }

    @GetMapping("/model")
    public List<Advertisements> getCarsByModel(@RequestParam Model model) {
        return advertisementManager.getCarsByModel(model);
    }

    @GetMapping("/location")
    public List<Advertisements> getCarsByLocation(@RequestParam Location location) {
        return advertisementManager.getCarsByLocation(location);
    }
}
