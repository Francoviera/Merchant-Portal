package com.backOffice_electric_cooperative.demo.application.usecases.client;

import com.backOffice_electric_cooperative.demo.domain.ports.input.client.DeleteClient;
import com.backOffice_electric_cooperative.demo.domain.ports.output.ClientRepositoryPort;

public class DeleteClientImpl implements DeleteClient {
    private final ClientRepositoryPort clientRepositoryPort;

    public DeleteClientImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public boolean deleteClient(Long id) {
        return clientRepositoryPort.delete(id);
    }
}
