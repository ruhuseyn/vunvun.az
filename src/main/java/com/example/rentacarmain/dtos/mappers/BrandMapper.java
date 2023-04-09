package com.example.rentacarmain.dtos.mappers;

import com.example.rentacarmain.dtos.brand.BrandDTO;
import com.example.rentacarmain.entities.advertisement.Brand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface BrandMapper {

    BrandDTO toBrandDTO(Brand brand);

    Brand fromBrandDTO(BrandDTO request);

}
