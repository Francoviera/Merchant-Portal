package com.backOffice_electric_cooperative.demo.infastructure.controllers;

import com.backOffice_electric_cooperative.demo.application.dto.request.AuthenticationRequest;
import com.backOffice_electric_cooperative.demo.application.dto.request.RegisterRequest;
import com.backOffice_electric_cooperative.demo.application.dto.response.AuthenticationResponse;
import com.backOffice_electric_cooperative.demo.application.services.AuthenticationService;
import com.backOffice_electric_cooperative.demo.application.services.UserService;
import com.backOffice_electric_cooperative.demo.domain.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authService;

    public AuthenticationController(UserService userService, AuthenticationService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
