package com.example.rentacarmain.mappers;

import com.example.rentacarmain.dtos.user.UserResponse;
import com.example.rentacarmain.entities.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserMapperTest {

    private final UserMapper userMapper = new UserMapperImpl();

    @Test
    void userToUserResponse() {

        var user = Users.builder().email("ruhuseyn@gmail.com")
                .budget(300.0).firstName("Rufet").lastName("Huseynov").build();

        var expected = new UserResponse("ruhuseyn@gmail.com",300.0,"Rufet","Huseynov");

        //Act
        UserResponse actual = userMapper.userToUserResponse(user);

        //Assert
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}