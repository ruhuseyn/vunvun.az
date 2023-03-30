package com.example.rentacarmain.controller;

import com.example.rentacarmain.dto.UserResponse;
import com.example.rentacarmain.managers.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserManager userManager;

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userManager.getUserById(id);
    }
}
