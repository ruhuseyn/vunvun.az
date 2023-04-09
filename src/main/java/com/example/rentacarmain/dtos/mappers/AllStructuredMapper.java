package com.example.rentacarmain.dtos.mappers;

import com.example.rentacarmain.dtos.adv.AdvertisementRequest;
import com.example.rentacarmain.dtos.adv.AdvertisementResponse;
import com.example.rentacarmain.dtos.location.LocationResponse;
import com.example.rentacarmain.dtos.model.ModelRequest;
import com.example.rentacarmain.dtos.model.ModelRequestReviews;
import com.example.rentacarmain.dtos.model.ModelResponse;
import com.example.rentacarmain.entities.advertisement.Advertisements;
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

    ModelResponse modelToModelResponse(Model model);

    LocationResponse locationToLocationResponse(Location location);









}
