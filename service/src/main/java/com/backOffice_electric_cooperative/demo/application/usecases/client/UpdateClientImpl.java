package com.backOffice_electric_cooperative.demo.application.usecases.client;
import com.backOffice_electric_cooperative.demo.domain.models.Client;
import com.backOffice_electric_cooperative.demo.domain.ports.input.client.UpdateClient;
import com.backOffice_electric_cooperative.demo.domain.ports.output.ClientRepositoryPort;

import java.util.Optional;

public class UpdateClientImpl implements UpdateClient {
    private final ClientRepositoryPort clientRepositoryPort;

    public UpdateClientImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Client> updateClient(Client client) {
        return clientRepositoryPort.update(client);
    }
}
