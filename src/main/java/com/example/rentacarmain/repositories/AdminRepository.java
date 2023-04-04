package com.example.rentacarmain.repositories;

import com.example.rentacarmain.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Users,Long> {
}
