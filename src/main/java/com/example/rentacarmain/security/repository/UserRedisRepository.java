package com.example.rentacarmain.security.repository;

import com.example.rentacarmain.security.entity.UserRedisHash;
import jakarta.transaction.Transactional;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRedisRepository {

    private static final String KEY = "user_hash";

    private final HashOperations<String,String, UserRedisHash> hashOperations;

    public UserRedisRepository(RedisTemplate<String,UserRedisHash> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(UserRedisHash userRedisHash){
        hashOperations.put(KEY,userRedisHash.getEmail(),userRedisHash);
    }

    public List<UserRedisHash> getAll(){
        return hashOperations.values(KEY);
    }

    public UserRedisHash getById(String email){
        return hashOperations.get(KEY,email);
    }

    @Transactional
    public void deleteById(String email){
        hashOperations.delete(KEY,email);
    }
}
