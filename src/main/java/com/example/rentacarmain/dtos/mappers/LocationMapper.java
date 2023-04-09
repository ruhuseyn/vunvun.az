package com.example.rentacarmain.dtos.mappers;

import com.example.rentacarmain.dtos.location.LocationRequest;
import com.example.rentacarmain.dtos.location.LocationResponse;
import com.example.rentacarmain.entities.advertisement.Location;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface LocationMapper {

    LocationResponse toLocationResponse(Location location);

    Location fromLocationRequest(LocationRequest request);

}
