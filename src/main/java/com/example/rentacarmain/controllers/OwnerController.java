package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.response.OwnerResponse;
import com.example.rentacarmain.entities.Users;
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

    @GetMapping("/{id}/user")
    public Users getOwnerUserById(@PathVariable("id") Long id){
        return ownerManager.getOwnerUserById(id);
    }

    @PostMapping("/add")
    public void addOwner(@Valid @RequestBody OwnerResponse ownerResponse){
        ownerManager.addOwner(ownerResponse);
    }

    @GetMapping("/user/{id}")
    public OwnerResponse getOwnerByUserId(@PathVariable(name = "id") Long id){
        return ownerManager.getOwnerByUserId(id);
    }
}
