package com.backOffice_electric_cooperative.demo.application.services;

import com.backOffice_electric_cooperative.demo.domain.models.AdditionalClientInfo;
import com.backOffice_electric_cooperative.demo.domain.models.Client;
import com.backOffice_electric_cooperative.demo.domain.ports.input.client.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements DeleteClient, NewClient, RetrieveClient, UpdateClient, GetAdditionalClientInfoUseCase {

    private final NewClient newClientImpl;
    private final RetrieveClient retrieveClientImpl;
    private final UpdateClient updateClientImpl;
    private final DeleteClient deleteClientImpl;
    private final GetAdditionalClientInfoUseCase getAdditionalClientInfoUseCase;

    public ClientService(NewClient newClient, RetrieveClient retrieveClient, UpdateClient updateClient, DeleteClient deleteClient, GetAdditionalClientInfoUseCase getAdditionalClientInfoUseCase) {
        this.newClientImpl = newClient;
        this.retrieveClientImpl = retrieveClient;
        this.updateClientImpl = updateClient;
        this.deleteClientImpl = deleteClient;
        this.getAdditionalClientInfoUseCase= getAdditionalClientInfoUseCase;
    }


    @Override
    public boolean deleteClient(Long id) {
        return deleteClientImpl.deleteClient(id);
    }

    @Override
    public Client newClient(Client client) {
        return newClientImpl.newClient(client);
    }

    @Override
    public Optional<Client> updateClient(Client client) {
        return updateClientImpl.updateClient(client);
    }

    @Override
    public Optional<Client> getClient(Long id) {
        return retrieveClientImpl.getClient(id);
    }

    @Override
    public List<Client> getAllClients() {
        return retrieveClientImpl.getAllClients();
    }

    @Override
    public AdditionalClientInfo getAdditionalClientInfo(Long id) {
        return getAdditionalClientInfoUseCase.getAdditionalClientInfo(id);
    }
}
