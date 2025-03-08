package com.backOffice_electric_cooperative.demo.domain.ports.input.user;

import com.backOffice_electric_cooperative.demo.domain.models.Transaction;
import com.backOffice_electric_cooperative.demo.domain.models.User;

import java.util.Optional;

public interface UpdateUser {
    Optional<User> updateUser(User user);
}
