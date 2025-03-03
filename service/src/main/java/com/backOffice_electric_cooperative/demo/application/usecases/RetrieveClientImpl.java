package com.backOffice_electric_cooperative.demo.application.usecases;

import com.backOffice_electric_cooperative.demo.domain.models.Client;
import com.backOffice_electric_cooperative.demo.domain.ports.input.client.RetrieveClient;
import com.backOffice_electric_cooperative.demo.domain.ports.output.ClientRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveClientImpl implements RetrieveClient {
    private final ClientRepositoryPort clientRepositoryPort;

    public RetrieveClientImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Client> getClient(Long id) {
        return clientRepositoryPort.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepositoryPort.findAll();
    }
}
