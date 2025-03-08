package com.backOffice_electric_cooperative.demo.application.services;

import com.backOffice_electric_cooperative.demo.application.usecases.user.CreateUserImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.user.DeleteUserImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.user.RetrieveUserImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.user.UpdateUserImpl;
import com.backOffice_electric_cooperative.demo.domain.models.User;
import com.backOffice_electric_cooperative.demo.domain.ports.input.user.*;

import java.util.List;
import java.util.Optional;

public class UserService implements DeleteUser, NewUser, UpdateUser, RetrieveUser, GetAdditionalUserInfo {
    private final DeleteUserImpl deleteUserImpl;
    private final CreateUserImpl createUserImpl;
    private final UpdateUserImpl updateUserImpl;
    private final RetrieveUserImpl retrieveUserImpl;
    private final GetAdditionalUserInfo getAdditionalUserInfoImpl;

    public UserService(DeleteUserImpl deleteUserImpl, CreateUserImpl createUserImpl, UpdateUserImpl updateUserImpl, RetrieveUserImpl retrieveUserImpl, GetAdditionalUserInfo getAdditionalUserInfoImpl) {
        this.deleteUserImpl = deleteUserImpl;
        this.createUserImpl = createUserImpl;
        this.updateUserImpl = updateUserImpl;
        this.retrieveUserImpl = retrieveUserImpl;
        this.getAdditionalUserInfoImpl = getAdditionalUserInfoImpl;
    }

    @Override
    public GetAdditionalUserInfo getAdditionalUserInfo(Long id) {
        return this.getAdditionalUserInfoImpl.getAdditionalUserInfo(id);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return this.retrieveUserImpl.getUser(id);
    }

    @Override
    public List<User> getAllUser() {
        return this.retrieveUserImpl.getAllUser();
    }

    @Override
    public boolean deleteUser(Long id) {
        return this.deleteUserImpl.deleteUser(id);
    }

    @Override
    public User newUser(User user) {
        return this.createUserImpl.newUser(user);
    }

    @Override
    public Optional<User> updateUser(User user) {
        return this.updateUserImpl.updateUser(user);
    }
}
