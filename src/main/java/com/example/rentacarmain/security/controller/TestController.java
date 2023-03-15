package com.example.rentacarmain.security.controller;

import com.ruhuseyn.racauth.entity.UserRedisHash;
import com.ruhuseyn.racauth.repository.UserRedisRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public record TestController(
        UserRedisRepository redisRepository
) {

    @GetMapping
    public List<UserRedisHash> getAll() {
        return redisRepository.getAll();
    }

    @GetMapping("/{id}")
    public UserRedisHash getById(@PathVariable("id") String email){
    return redisRepository.getById(email);
    }

}
