package com.backOffice_electric_cooperative.demo.application.usecases.user;

import com.backOffice_electric_cooperative.demo.domain.models.User;
import com.backOffice_electric_cooperative.demo.domain.ports.input.user.NewUser;
import com.backOffice_electric_cooperative.demo.domain.ports.output.UserRepositoryPort;

public class CreateUserImpl implements NewUser {
    private final UserRepositoryPort userRepositoryPort;

    public CreateUserImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User newUser(User user) {
        return this.userRepositoryPort.save(user);
    }
}
