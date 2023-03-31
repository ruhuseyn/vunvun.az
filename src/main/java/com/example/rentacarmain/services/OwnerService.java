package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.OwnerResponse;
import com.example.rentacarmain.entities.Users;

public interface OwnerService{

    OwnerResponse getOwnerById(Long id);

    void addOwner(OwnerResponse ownerResponse);

    OwnerResponse getOwnerByUserId(Long id);

    Users getOwnerUserById(Long id);
}
