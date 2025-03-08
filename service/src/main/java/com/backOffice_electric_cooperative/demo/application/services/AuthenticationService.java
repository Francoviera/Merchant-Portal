package com.backOffice_electric_cooperative.demo.application.services;

import com.backOffice_electric_cooperative.demo.application.dto.request.AuthenticationRequest;
import com.backOffice_electric_cooperative.demo.application.dto.request.RegisterRequest;
import com.backOffice_electric_cooperative.demo.application.dto.response.AuthenticationResponse;
import com.backOffice_electric_cooperative.demo.domain.models.Role;
import com.backOffice_electric_cooperative.demo.domain.ports.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        var user= User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(String.valueOf(Role.User))
                .build();
        userRepositoryPort.save((com.backOffice_electric_cooperative.demo.domain.models.User) user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user= this.userRepositoryPort.findByEmail(request.getUsername())
                .orElseThrow();
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
