package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.OwnerResponse;

public interface OwnerService{

    OwnerResponse getOwnerById(Long id);

    void addOwner(OwnerResponse ownerResponse);

    OwnerResponse getOwnerByUserId(Long id);
}
