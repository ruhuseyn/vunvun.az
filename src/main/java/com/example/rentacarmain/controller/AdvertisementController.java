package com.example.rentacarmain.controller;

import com.example.rentacarmain.dto.AdvertisementRequest;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.managers.AdvertisementManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementManager advertisementManager;
    private static final Logger logger = LoggerFactory.getLogger(AdvertisementController.class);


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addAdv(@RequestBody AdvertisementRequest request){
        logger.debug("AdvertisementController: addAdv method is called");
        advertisementManager.addAdvertisement(request);
        return "Ugurla elave edildi";
    }


}
