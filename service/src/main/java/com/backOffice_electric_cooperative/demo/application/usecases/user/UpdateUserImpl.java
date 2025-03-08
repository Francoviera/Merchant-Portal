package com.backOffice_electric_cooperative.demo.application.usecases.user;

import com.backOffice_electric_cooperative.demo.domain.models.User;
import com.backOffice_electric_cooperative.demo.domain.ports.input.user.UpdateUser;
import com.backOffice_electric_cooperative.demo.domain.ports.output.UserRepositoryPort;
import com.backOffice_electric_cooperative.demo.infastructure.repositories.JpaUserRepository;

import java.util.Optional;

public class UpdateUserImpl implements UpdateUser {
    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> updateUser(User user) {
        return Optional.of(this.userRepositoryPort.save(user));
    }
}
