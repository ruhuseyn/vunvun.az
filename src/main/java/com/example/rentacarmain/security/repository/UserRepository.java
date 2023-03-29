package com.example.rentacarmain.security.repository;

import com.example.rentacarmain.entities.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Optional<Users> findUserByEmail(String email);

    @Transactional
    void deleteUserByEmail(String email);

    boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query("update users u set u.active = :active where u.email = :email")
    void activateByEmail(@Param("active") boolean active,@Param("email") String email);

}
