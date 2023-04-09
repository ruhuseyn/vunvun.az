package com.example.rentacarmain.dtos.mappers;

import com.example.rentacarmain.dtos.user.PatchUserRequest;
import com.example.rentacarmain.dtos.user.UserRequest;
import com.example.rentacarmain.dtos.user.UserResponse;
import com.example.rentacarmain.entities.Users;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {

    UserResponse userToUserResponse(Users users);

    Users UserRequestToUser(PatchUserRequest request);

    Users fromUserRequest(UserRequest request);

}
