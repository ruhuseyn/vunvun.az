package com.example.rentacarmain.dtos.mappers;

import com.example.rentacarmain.dtos.request.AdvertisementRequest;
import com.example.rentacarmain.dtos.request.ModelRequest;
import com.example.rentacarmain.dtos.request.ModelRequestReviews;
import com.example.rentacarmain.dtos.response.AdvertisementResponse;
import com.example.rentacarmain.dtos.response.BrandResponse;
import com.example.rentacarmain.dtos.response.LocationResponse;
import com.example.rentacarmain.dtos.response.ModelResponse;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface AllStructuredMapper {

    Advertisements advRequestToAdv(AdvertisementRequest advertisementRequest);

    Model modelRequestToModel(ModelRequest modelRequest);


    AdvertisementResponse advToAdvResponse(Advertisements advertisements);

    List<ModelRequestReviews> modelToModelReviewsList(List<Model> models);

    BrandResponse brandToBrandResponse(Brand brand);

    ModelResponse modelToModelResponse(Model model);

    LocationResponse locationToLocationResponse(Location location);








}
