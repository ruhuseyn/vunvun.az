package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.AdvertisementRequest;
import com.example.rentacarmain.dtos.AdvertisementResponse;
import com.example.rentacarmain.dtos.DetailedAdvResponse;
import com.example.rentacarmain.managers.AdvertisementManager;
import jakarta.validation.Valid;
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
    public Long addAdv(@Valid @RequestBody AdvertisementRequest request){
        logger.debug("AdvertisementController: addAdv method is called");
        return advertisementManager.addAdvertisement(request);
    }

    @GetMapping("/{id}")
    public DetailedAdvResponse getById(@PathVariable("id") Long id){
        logger.debug("AdvertisementController: getById method is called");
        return advertisementManager.getAdvertisementById(id);
    }


}
