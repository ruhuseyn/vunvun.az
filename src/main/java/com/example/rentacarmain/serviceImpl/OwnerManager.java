package com.example.rentacarmain.serviceImpl;

import com.example.rentacarmain.dtos.owner.OwnerResponse;
import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.entities.Users;
import com.example.rentacarmain.exceptions.subexceptions.OwnerNotFoundException;
import com.example.rentacarmain.mappers.OwnerMapper;
import com.example.rentacarmain.repositories.OwnerRepository;
import com.example.rentacarmain.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerManager implements OwnerService {

    private final OwnerRepository ownerRepository;
        private final OwnerMapper ownerMapper;
    @Override
    public OwnerResponse getOwnerById(Long id) {
        Owners owners = ownerRepository.findById(id)
                .orElseThrow(()->new OwnerNotFoundException("Owner is not found "+id));
        return ownerMapper.ownerToOwnerResponse(owners);
    }

    @Override
    public void addOwner(OwnerResponse ownerResponse) {
        ownerRepository.save(ownerMapper.ownerResponseToOwner(ownerResponse));
    }

    @Override
    public OwnerResponse getOwnerByUserId(Long id) {
        Owners owners = ownerRepository.findOwnersByUserId(id)
                .orElseThrow(()->new OwnerNotFoundException("Owner is not found "+id));;
        return ownerMapper.ownerToOwnerResponse(owners);
    }

    @Override
    public Users getOwnerUserById(Long id) {
        return ownerRepository
                .findById(id)
                .orElseThrow(()->new OwnerNotFoundException("Owner is not found "+id))
                .getUser();
    }

}
