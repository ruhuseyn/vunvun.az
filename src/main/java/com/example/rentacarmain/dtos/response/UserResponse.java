package com.example.rentacarmain.dtos.response;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse{

    @Null
    String email;

    Double budget;

    String firstName;

    String lastName;
}



