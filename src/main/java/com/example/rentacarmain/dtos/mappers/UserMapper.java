package com.example.rentacarmain.dtos.mappers;

import com.example.rentacarmain.dtos.response.UserResponse;
import com.example.rentacarmain.entities.Users;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {

    UserResponse userToUserResponse(Users users);

    Users userDtoToUser(UserResponse userResponse);
}
