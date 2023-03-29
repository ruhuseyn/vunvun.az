package com.example.rentacarmain.repositories;

import com.example.rentacarmain.entities.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owners,Long> {

    Owners findOwnersByUserId(Long id);
}
