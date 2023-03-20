package com.example.rentacarmain.security.entity;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Builder
@Data
public class UserRedisHash implements Serializable {


    String email;

    String password;

    String verificationCode;

    LocalDateTime generatedDateTime;

}
