package com.example.rentacarmain.serviceImpl;

import com.example.rentacarmain.dtos.user.PatchUserRequest;
import com.example.rentacarmain.dtos.user.UserResponse;
import com.example.rentacarmain.entities.Users;
import com.example.rentacarmain.exceptions.subexceptions.UserNotFoundException;
import com.example.rentacarmain.mappers.UserMapper;
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

        return userMapper.userToUserResponse(findById(id));
    }

    @Override
    public void patchUserById(Long id, PatchUserRequest request) {
        Users user = findById(id);


        if (request.lastName() == null && request.firstName() == null) {
            throw new IllegalArgumentException("Please type firstName or lastName for patch");
        } else {
            if (request.firstName() != null) {
                user.setFirstName(request.firstName());
            }
            if (request.lastName() != null) {
                user.setLastName(request.lastName());
            }
        }


        userRepository.save(user);
    }

    private Users findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User is not found " + id));
    }

}
