package com.backOffice_electric_cooperative.demo.domain.ports.output;

import com.backOffice_electric_cooperative.demo.domain.models.Client;
import com.backOffice_electric_cooperative.demo.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    Optional<User> update (User user);
    boolean delete(Long id);
}
