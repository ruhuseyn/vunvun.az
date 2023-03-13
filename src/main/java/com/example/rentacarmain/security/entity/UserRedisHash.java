package com.example.rentacarmain.security.entity;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


//@RedisHash("users")
@Builder
@Data
public class UserRedisHash implements Serializable {


    String email;

    String verificationCode;

    LocalDateTime generatedDateTime;

}
