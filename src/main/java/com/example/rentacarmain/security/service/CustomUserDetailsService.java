package com.example.rentacarmain.security.service;

import com.ruhuseyn.racauth.entity.CustomUserDetails;
import com.ruhuseyn.racauth.entity.User;
import com.ruhuseyn.racauth.exception.IncorrectEmailException;
import com.ruhuseyn.racauth.repository.UserRepository;
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
