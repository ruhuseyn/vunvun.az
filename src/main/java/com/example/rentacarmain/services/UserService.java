package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.response.UserResponse;

public interface UserService {

    UserResponse getUserById(Long id);
}
