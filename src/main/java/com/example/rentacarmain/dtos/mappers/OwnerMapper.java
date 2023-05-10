package com.example.rentacarmain.dtos.mappers;

import com.example.rentacarmain.dtos.request.OwnerRequest;
import com.example.rentacarmain.dtos.response.OwnerResponse;
import com.example.rentacarmain.entities.Owners;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface OwnerMapper {

    Owners ownerRequestToOwners(OwnerRequest ownerRequest);

    OwnerResponse ownerToOwnerResponse(Owners owners);

    Owners ownerResponseToOwner(OwnerResponse ownerResponse);
}
