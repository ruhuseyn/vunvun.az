package com.example.rentacarmain.security.service;

import com.example.rentacarmain.security.entity.User;
import com.example.rentacarmain.security.exception.IncorrectEmailException;
import com.example.rentacarmain.security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public record CustomUserDetailsService(UserRepository service) implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = service.findUserByEmail(email);
        return user.map(CustomUserDetails::new).orElseThrow(() -> new IncorrectEmailException("not found"));
    }
}
