package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.UserResponse;

public interface UserService {

    UserResponse getUserById(Long id);
}
