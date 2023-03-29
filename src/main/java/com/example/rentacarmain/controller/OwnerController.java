package com.example.rentacarmain.controller;

import com.example.rentacarmain.dto.OwnerResponse;
import com.example.rentacarmain.managers.OwnerManager;
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
    public void addOwner(@RequestBody OwnerResponse ownerResponse){
        ownerManager.addOwner(ownerResponse);
    }
}
