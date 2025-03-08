package com.backOffice_electric_cooperative.demo.infastructure.repositories;

import com.backOffice_electric_cooperative.demo.infastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email); // ✅ Find user by username
}
