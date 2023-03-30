package com.example.rentacarmain.services;

import com.example.rentacarmain.dto.UserResponse;
import com.example.rentacarmain.entities.Users;

public interface UserService {

    UserResponse getUserById(Long id);
}
