package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.user.PatchUserRequest;
import com.example.rentacarmain.dtos.user.UserResponse;

public interface UserService {

    UserResponse getUserById(Long id);

    void patchUserById(Long id,PatchUserRequest request);
}
