package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.user.PatchUserRequest;
import com.example.rentacarmain.dtos.user.UserResponse;
import com.example.rentacarmain.services.serviceImpl.UserManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public record UserController(
        UserManager userManager
) {

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userManager.getUserById(id);
    }

    @PatchMapping("/{id}")
    public void patchUserById(@PathVariable Long id, @RequestBody PatchUserRequest request){
        userManager.patchUserById(id,request);
    }
}
