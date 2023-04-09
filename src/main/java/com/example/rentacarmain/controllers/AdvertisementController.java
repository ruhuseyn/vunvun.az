package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.adv.AdvertisementRequest;
import com.example.rentacarmain.dtos.adv.DetailedAdvResponse;
import com.example.rentacarmain.serviceImpl.AdvertisementManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/advertisement")
public record AdvertisementController(
        AdvertisementManager advertisementManager
) {
    private static final Logger logger = LoggerFactory.getLogger(AdvertisementController.class);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @PreAuthorize("hasRole('OWNER')")
    public Long addAdv(@Valid @RequestBody AdvertisementRequest request){
        logger.debug("AdvertisementController: addAdv method is called");
        return advertisementManager.add(request);
    }

    @GetMapping("/{id}")
    public DetailedAdvResponse getById(@PathVariable("id") Long id){
        logger.debug("AdvertisementController: getById method is called");
        return advertisementManager.getById(id);
    }


}
