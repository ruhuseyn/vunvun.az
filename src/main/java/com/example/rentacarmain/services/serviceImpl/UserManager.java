package com.example.rentacarmain.services.serviceImpl;

import com.example.rentacarmain.dtos.response.UserResponse;
import com.example.rentacarmain.exceptions.subexceptions.UserNotFoundException;
import com.example.rentacarmain.dtos.mappers.UserMapper;
import com.example.rentacarmain.repositories.UserRepository;
import com.example.rentacarmain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponse getUserById(Long id) {

        return userMapper.userToUserResponse(userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("User is not found "+id)));
    }
}
