package com.backOffice_electric_cooperative.demo.infastructure.config;

import com.backOffice_electric_cooperative.demo.infastructure.repositories.JpaUserRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable()) // Deshabilita CSRF (opcional, pero recomendado para APIs REST)
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 🔄 Stateless session management for APIs
                    .authenticationProvider(authenticationProvider)
                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("api/v1/auth/**").permitAll() // ✅ Public routes
                            .anyRequest()
                            .authenticated()
                    );
        return http.build();
    }
}
/*.authorizeHttpRequests(auth -> auth
        .anyRequest().permitAll() // Permite el acceso a todas las rutas sin autenticación
                    )*/