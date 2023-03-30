package com.example.rentacarmain.mappers;

import com.example.rentacarmain.dtos.OwnerRequest;
import com.example.rentacarmain.dtos.OwnerResponse;
import com.example.rentacarmain.dtos.UserRequest;
import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.entities.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapperTest {

    private final OwnerMapper ownerMapper = new OwnerMapperImpl();

    @Test
    void ownerRequestToOwners() {

        var ownerRequest = new OwnerRequest(1L);

        var expected = Owners.builder().id(1L).build();

        //Act
        Owners actual = ownerMapper.ownerRequestToOwners(ownerRequest);

        //ASSERT
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void ownerToOwnerResponse() {
        UserRequest userRequest = new UserRequest(1L);

        var owner = Owners.builder().phoneNumber("055-555-55-55").user(Users.builder().id(1L).build()).build();

        var expected = new OwnerResponse("055-555-55-55",userRequest);

        //Act
        OwnerResponse actual = ownerMapper.ownerToOwnerResponse(owner);

        //ASSERT
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void ownerResponseToOwner() {
        UserRequest userRequest = new UserRequest(1L);

        var ownerResponse = new OwnerResponse("055-555-55-55",userRequest);

        var expected =  Owners.builder().phoneNumber("055-555-55-55").user(Users.builder().id(1L).build()).build();

        //Act
        Owners actual = ownerMapper.ownerResponseToOwner(ownerResponse);

        //Assert
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}