package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.response.UserResponse;

public interface AdminService {

    void deleteUserById(Long id);

    void updateUser(Long id, UserResponse userResponse);
}
