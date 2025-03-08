package com.backOffice_electric_cooperative.demo.application.usecases.user;

import com.backOffice_electric_cooperative.demo.domain.ports.input.user.DeleteUser;
import com.backOffice_electric_cooperative.demo.domain.ports.output.UserRepositoryPort;

public class DeleteUserImpl implements DeleteUser {
    private final UserRepositoryPort userRepositoryPort;

    public DeleteUserImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public boolean deleteUser(Long id) {
        return this.userRepositoryPort.delete(id);
    }
}
