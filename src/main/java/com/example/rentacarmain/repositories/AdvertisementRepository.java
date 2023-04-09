package com.example.rentacarmain.repositories;

import com.example.rentacarmain.entities.advertisement.Advertisements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisements,Long> {

    @Query("update advertisement set isActive = true")
    void activateById(Long id);

    @Query("update advertisement set isActive = false")
    void deactivateById(Long id);

}
