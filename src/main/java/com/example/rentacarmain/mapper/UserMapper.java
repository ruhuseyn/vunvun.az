package com.example.rentacarmain.mapper;

import com.example.rentacarmain.dto.UserResponse;
import com.example.rentacarmain.entities.Users;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {

    UserResponse userToUserResponse(Users users);
}
