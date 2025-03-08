package com.backOffice_electric_cooperative.demo.domain.ports.input.user;

import com.backOffice_electric_cooperative.demo.domain.models.User;

public interface NewUser {
    User newUser(User user);
}
