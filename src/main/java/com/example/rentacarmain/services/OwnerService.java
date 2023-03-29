package com.example.rentacarmain.services;

import com.example.rentacarmain.dto.OwnerResponse;
import com.example.rentacarmain.entities.Owners;

public interface OwnerService{

    OwnerResponse getOwnerById(Long id);

    void addOwner(OwnerResponse ownerResponse);
}
