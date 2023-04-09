package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.brand.BrandDTO;
import com.example.rentacarmain.dtos.location.LocationRequest;
import com.example.rentacarmain.dtos.model.AddModelRequest;
import com.example.rentacarmain.dtos.user.UserRequest;
import com.example.rentacarmain.services.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public record AdminController(
        OwnerService ownerService,
        UserService userService,
        AdvertisementsService advertisementsService,
        BrandService brandService,
        ModelService modelService,
        LocationService locationService

) {

    // INFO : LOCATION
    @PostMapping("/locations")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addLocation(@Valid @RequestBody LocationRequest request) {
        locationService.save(request);
    }

    @DeleteMapping("/locations/{id}")
    public void deleteLocation(@PathVariable Long id){
        locationService.deleteById(id);
    }

    // INFO : MODEL
    @PostMapping("/models")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addModel(@Valid @RequestBody AddModelRequest request) {
        modelService.add(request);
    }

    @DeleteMapping("/models/{id}")
    public void deleteModel(@PathVariable Long id){
        modelService.deleteById(id);
    }

    // INFO : BRAND
    @PostMapping("/brands")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addBrand(@Valid @RequestBody BrandDTO request){
        brandService.add(request);
    }

    @DeleteMapping("/models/{id}")
    public void deleteBrand(@PathVariable Long id){
        brandService.deleteById(id);
    }


    // INFO : ADV
    @DeleteMapping("/advertisements/{id}")
    public void deleteAdvertisement(@PathVariable Long id){
        advertisementsService.deleteById(id);
    }

    @PatchMapping("/advertisements/{id}/{process}")
    public void patchAdvertisement(@PathVariable("id") Long id,@PathVariable("process") @Valid @NotBlank String process){
        advertisementsService.patchById(id,process);
    }


    // INFO : USER
    @PostMapping("/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addUser(@Valid @RequestBody UserRequest request) {
        userService.save(request);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }

    @PatchMapping("/users/{id}/{process}")
    public void patchUser(@PathVariable("id") Long id,
                          @PathVariable("process")
                          @Valid @Size(min = 8,message = "process daxil edin!") String process){
        userService.patchById(id,process);
    }


}
