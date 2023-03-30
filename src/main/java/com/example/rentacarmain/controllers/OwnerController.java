package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.OwnerResponse;
import com.example.rentacarmain.managers.OwnerManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerManager ownerManager;

    @GetMapping("/{id}")
    public OwnerResponse getOwnerById(@PathVariable Long id){
        return ownerManager.getOwnerById(id);
    }

    @PostMapping("/add")
    public void addOwner(@Valid @RequestBody OwnerResponse ownerResponse){
        ownerManager.addOwner(ownerResponse);
    }

    @GetMapping("/user/{id}")
    public OwnerResponse getOwnerByUserId(Long id){
        return ownerManager.getOwnerByUserId(id);
    }
}