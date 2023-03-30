package com.example.rentacarmain.managers;

import com.example.rentacarmain.dtos.OwnerResponse;
import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.exceptions.subexceptions.OwnerNotFoundException;
import com.example.rentacarmain.mappers.AllStructuredMapper;
import com.example.rentacarmain.repositories.OwnerRepository;
import com.example.rentacarmain.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerManager implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final AllStructuredMapper advertisementMapper;
    @Override
    public OwnerResponse getOwnerById(Long id) {
        Owners owners = ownerRepository.findById(id)
                .orElseThrow(()->new OwnerNotFoundException("Owner is not found "+id));
        return advertisementMapper.ownerToOwnerResponse(owners);
    }

    @Override
    public void addOwner(OwnerResponse ownerResponse) {
        ownerRepository.save(advertisementMapper.ownerResponseToOwner(ownerResponse));
    }

    @Override
    public OwnerResponse getOwnerByUserId(Long id) {
        Owners owners = ownerRepository.findOwnersByUserId(id)
                .orElseThrow(()->new OwnerNotFoundException("Owner is not found "+id));;
        return advertisementMapper.ownerToOwnerResponse(owners);
    }

}
