package com.backOffice_electric_cooperative.demo.application.usecases.client;

import com.backOffice_electric_cooperative.demo.domain.models.Client;
import com.backOffice_electric_cooperative.demo.domain.ports.input.client.NewClient;
import com.backOffice_electric_cooperative.demo.domain.ports.output.ClientRepositoryPort;

public class CreateClientImpl implements NewClient {
    private final ClientRepositoryPort clientRepositoryPort;

    public CreateClientImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Client newClient(Client client) {
        return clientRepositoryPort.save(client);
    }
}
