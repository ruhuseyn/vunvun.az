package com.example.rentacarmain.security.service;

import com.example.rentacarmain.security.entity.CustomUserDetails;
import com.example.rentacarmain.entities.Users;
import com.example.rentacarmain.security.exception.IncorrectEmailException;
import com.example.rentacarmain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> user = service.findUserByEmail(email);
        return user.map(CustomUserDetails::new).orElseThrow(() -> new IncorrectEmailException("Email və ya şifrə yanlışdır!"));
    }
}
