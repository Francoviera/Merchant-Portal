package com.backOffice_electric_cooperative.demo.domain.ports.input.client;

import com.backOffice_electric_cooperative.demo.domain.models.Client;

import java.util.List;
import java.util.Optional;

public interface RetrieveClient {
    Optional<Client> getClient(Long id);
    List<Client> getAllClients();
}
