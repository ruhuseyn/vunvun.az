package com.example.rentacarmain.services.serviceImpl;

import com.example.rentacarmain.dtos.user.PatchUserRequest;
import com.example.rentacarmain.dtos.user.UserRequest;
import com.example.rentacarmain.dtos.user.UserResponse;
import com.example.rentacarmain.entities.Users;
import com.example.rentacarmain.exceptions.subexceptions.UserNotFoundException;
import com.example.rentacarmain.dtos.mappers.UserMapper;
import com.example.rentacarmain.repositories.UserRepository;
import com.example.rentacarmain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public UserResponse getUserById(Long id) {

        return mapper.userToUserResponse(findById(id));
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


        repository.save(user);
    }

    @Override
    public void save(UserRequest request) {
        repository.save(mapper.fromUserRequest(request));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void patchById(Long id, String process) {
        if (process.equals("activate")) {
            repository.activateById(id);
        } else if (process.equals("deactivate")) {
            repository.deactivateById(id);
        }
    }

    private Users findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User is not found " + id));
    }

}
