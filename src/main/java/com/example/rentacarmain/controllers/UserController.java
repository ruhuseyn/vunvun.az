package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.user.PatchUserRequest;
import com.example.rentacarmain.dtos.user.UserResponse;
import com.example.rentacarmain.serviceImpl.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserManager userManager;

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userManager.getUserById(id);
    }

    @PatchMapping("/{id}")
    public void patchUserById(@PathVariable Long id, @RequestBody PatchUserRequest request){
        userManager.patchUserById(id,request);
    }
}
