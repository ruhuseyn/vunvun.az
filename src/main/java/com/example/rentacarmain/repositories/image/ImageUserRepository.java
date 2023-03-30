package com.example.rentacarmain.repositories.image;

import com.example.rentacarmain.entities.image.ImageUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageUserRepository extends JpaRepository<ImageUser,Long> {

    Optional<ImageUser> findImageUserByUserId(Long userId);

}
