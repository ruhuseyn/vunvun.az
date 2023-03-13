package com.example.rentacarmain.security.repository;

import com.ruhuseyn.racauth.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByEmail(String email);

    @Transactional
    void deleteUserByEmail(String email);

    @Transactional
    @Modifying
    @Query("update users u set u.active = :active where u.email = :email")
    void activateByEmail(@Param("active") boolean active,@Param("email") String email);

}
