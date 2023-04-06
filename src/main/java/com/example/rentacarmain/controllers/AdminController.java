package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.response.UserResponse;
import com.example.rentacarmain.managers.AdminManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public record AdminController(AdminManager adminManager) {

    @PutMapping("/update/{id}")
    public UserResponse updateUser(@PathVariable Long id,@RequestBody UserResponse userResponse){
        adminManager.updateUser(id,userResponse);
        return userResponse;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        adminManager.deleteUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserByIdAAndName(@PathVariable Long id){
        adminManager.deleteUserById(id);
    }
}
