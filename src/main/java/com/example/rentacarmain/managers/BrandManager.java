package com.example.rentacarmain.managers;

import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.exception.BrandAlreadyExistException;
import com.example.rentacarmain.exception.BrandNotFoundException;
import com.example.rentacarmain.repositories.BrandRepository;
import com.example.rentacarmain.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(()->new BrandNotFoundException("Brand is not found "+id));
    }

    @Override
    public void addBrand(Brand brand) {
        if(brandRepository.existsByName(brand.getName())){
            throw new BrandAlreadyExistException("Brand is already exist " + brand);
        }
        brandRepository.save(brand);
    }
}
