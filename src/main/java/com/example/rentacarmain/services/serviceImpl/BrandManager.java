package com.example.rentacarmain.services.serviceImpl;

import com.example.rentacarmain.dtos.brand.BrandDTO;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.exceptions.subexceptions.BrandAlreadyExistException;
import com.example.rentacarmain.exceptions.subexceptions.BrandNotFoundException;
import com.example.rentacarmain.dtos.mappers.BrandMapper;
import com.example.rentacarmain.repositories.BrandRepository;
import com.example.rentacarmain.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository repository;

    private final BrandMapper mapper;

    @Override
    public List<Brand> getAll() {
        return repository.findAll();
    }

    @Override
    public BrandDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toBrandDTO)
                .orElseThrow(()->new BrandNotFoundException("Brand is not found "+id));
    }

    @Override
    public void add(BrandDTO request) {
        if(repository.existsByName(request.name())){
            throw new BrandAlreadyExistException("Brand is already exist " + request);
        }
        repository.save(mapper.fromBrandDTO(request));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
