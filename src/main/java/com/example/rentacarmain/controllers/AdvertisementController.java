package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.adv.AdvertisementRequest;
import com.example.rentacarmain.dtos.adv.DetailedAdvResponse;
import com.example.rentacarmain.services.AdvertisementsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {
    private final AdvertisementsService advertisementsService;
    private static final Logger logger = LoggerFactory.getLogger(AdvertisementController.class);

    public AdvertisementController(AdvertisementsService advertisementsService) {
        this.advertisementsService = advertisementsService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @PreAuthorize("hasRole('OWNER')")
    public Long addAdv(@Valid @RequestBody AdvertisementRequest request) {
        logger.debug("AdvertisementController: addAdv method is called");
        return advertisementsService.add(request);
    }

    @GetMapping("/{id}")
    public DetailedAdvResponse getById(@PathVariable("id") Long id) {
        logger.debug("AdvertisementController: getById method is called");
        return advertisementsService.getById(id);
    }


}
