package com.example.rentacarmain.services.serviceImpl;

import com.example.rentacarmain.dtos.response.UserResponse;
import com.example.rentacarmain.entities.Users;
import com.example.rentacarmain.exceptions.subexceptions.UserNotFoundException;
import com.example.rentacarmain.dtos.mappers.UserMapper;
import com.example.rentacarmain.repositories.AdminRepository;
import com.example.rentacarmain.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminManager implements AdminService{

    private final AdminService adminService;
    private final AdminRepository adminRepository;
    private final UserMapper userMapper;

    @Override
    public void deleteUserById(Long id) {
        adminService.deleteUserById(id);
    }

    @Override
    public void updateUser(Long id, UserResponse userResponse) {
        Users user = adminRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User is not found " + id));

        UserResponse newUser = userMapper.userToUserResponse(user);
        newUser.setFirstName(userResponse.getFirstName());
        newUser.setLastName(userResponse.getLastName());
        newUser.setBudget(userResponse.getBudget());
        newUser.setEmail(userResponse.getEmail());

        adminRepository.save(userMapper.userDtoToUser(newUser));
    }
}
