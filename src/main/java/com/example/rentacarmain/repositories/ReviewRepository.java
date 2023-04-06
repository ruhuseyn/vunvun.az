package com.example.rentacarmain.repositories;

import com.example.rentacarmain.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews,Long> {

    Optional<Reviews> findByAdvertisements_Id(Long advertisementId);
}
