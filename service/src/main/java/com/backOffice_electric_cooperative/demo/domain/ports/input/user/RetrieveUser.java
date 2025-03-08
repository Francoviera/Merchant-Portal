package com.backOffice_electric_cooperative.demo.domain.ports.input.user;

import com.backOffice_electric_cooperative.demo.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface RetrieveUser {
    Optional<User> getUser(Long id);
    List<User> getAllUser();
}
