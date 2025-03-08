package com.backOffice_electric_cooperative.demo.application.usecases.user;

import com.backOffice_electric_cooperative.demo.domain.models.User;
import com.backOffice_electric_cooperative.demo.domain.ports.input.user.RetrieveUser;
import com.backOffice_electric_cooperative.demo.domain.ports.output.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveUserImpl implements RetrieveUser {
    private final UserRepositoryPort userRepositoryPort;

    public RetrieveUserImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> getUser(Long id) {
        return this.userRepositoryPort.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepositoryPort.findAll();
    }
}
