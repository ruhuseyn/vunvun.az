package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.user.PatchUserRequest;
import com.example.rentacarmain.dtos.user.UserRequest;
import com.example.rentacarmain.dtos.user.UserResponse;

public interface UserService {

    UserResponse getUserById(Long id);

    void patchUserById(Long id,PatchUserRequest request);

    void save(UserRequest request);

    void deleteById(Long id);

    void patchById(Long id, String process);
}
