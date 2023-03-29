package com.example.rentacarmain.managers;

import com.example.rentacarmain.dto.OwnerResponse;
import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.exception.subexceptions.OwnerNotFoundException;
import com.example.rentacarmain.mapper.AdvertisementMapper;
import com.example.rentacarmain.repositories.OwnerRepository;
import com.example.rentacarmain.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerManager implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final AdvertisementMapper advertisementMapper;
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
        Owners owners = ownerRepository.findOwnersByUserId(id);

        return null;
    }

}
