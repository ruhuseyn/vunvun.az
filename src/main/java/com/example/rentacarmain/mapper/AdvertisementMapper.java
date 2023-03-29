package com.example.rentacarmain.mapper;

import com.example.rentacarmain.dto.*;
import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Model;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface AdvertisementMapper {

    Advertisements advRequestToAdv(AdvertisementRequest advertisementRequest);

    Model modelRequestToModel(ModelRequest modelRequest);

    Owners ownerRequestToOwners(OwnerRequest ownerRequest);

    AdvertisementResponse advToAdvResponse(Advertisements advertisements);

    List<ModelRequestReviews> modelToModelReviewsList(List<Model> models);

    OwnerResponse ownerToOwnerResponse(Owners owners);
    Owners ownerResponseToOwner(OwnerResponse ownerResponse);

}
