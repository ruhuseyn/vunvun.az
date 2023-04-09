package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.owner.OwnerResponse;
import com.example.rentacarmain.entities.Users;
import com.example.rentacarmain.services.OwnerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public record OwnerController(
        OwnerService service
) {

    @GetMapping("/{id}")
    public OwnerResponse getOwnerById(@PathVariable Long id){
        return service.getOwnerById(id);
    }

    @GetMapping("/{id}/user")
    public Users getOwnerUserById(@PathVariable("id") Long id){
        return service.getOwnerUserById(id);
    }

    @PostMapping("/add")
    public void addOwner(@Valid @RequestBody OwnerResponse ownerResponse){
        service.addOwner(ownerResponse);
    }

    @GetMapping("/user/{id}")
    public OwnerResponse getOwnerByUserId(@PathVariable(name = "id") Long id){
        return service.getOwnerByUserId(id);
    }
}
