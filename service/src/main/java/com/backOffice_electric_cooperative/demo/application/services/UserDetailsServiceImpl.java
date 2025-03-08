package com.backOffice_electric_cooperative.demo.application.services;

import com.backOffice_electric_cooperative.demo.infastructure.repositories.JpaUserRepositoryAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // ✅ Now it's an independent service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final JpaUserRepositoryAdapter userRepository; // ✅ Injecting repository directly

    public UserDetailsServiceImpl(JpaUserRepositoryAdapter userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(user -> new User(
                        user.getEmail(),
                        user.getPassword(),
                        List.of(() -> "ROLE_" + user.getRole()) // ✅ Convert role correctly
                ))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
    }
}