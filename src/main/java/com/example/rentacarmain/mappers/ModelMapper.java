package com.example.rentacarmain.mappers;

import com.example.rentacarmain.dtos.model.AddModelRequest;
import com.example.rentacarmain.entities.advertisement.Model;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ModelMapper {

    Model fromAddModelRequest(AddModelRequest request);


}
