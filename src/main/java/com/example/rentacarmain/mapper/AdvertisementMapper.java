package com.example.rentacarmain.mapper;

import com.example.rentacarmain.dto.AdvertisementRequest;
import com.example.rentacarmain.dto.ModelRequest;
import com.example.rentacarmain.dto.OwnerRequest;
import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Model;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "Advertisement", injectionStrategy = InjectionStrategy.FIELD)
public interface AdvertisementMapper {

    Advertisements advRequestToAdv(AdvertisementRequest advertisementRequest);

    Model modelRequestToModel(ModelRequest modelRequest);

    Owners ownerRequestToOwners(OwnerRequest ownerRequest);

}
