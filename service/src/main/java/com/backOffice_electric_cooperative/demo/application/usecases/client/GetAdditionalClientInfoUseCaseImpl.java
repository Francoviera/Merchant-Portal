package com.backOffice_electric_cooperative.demo.application.usecases.client;

import com.backOffice_electric_cooperative.demo.domain.models.AdditionalClientInfo;
import com.backOffice_electric_cooperative.demo.domain.ports.input.client.GetAdditionalClientInfoUseCase;
import com.backOffice_electric_cooperative.demo.domain.ports.output.ExternalServicePort;

public class GetAdditionalClientInfoUseCaseImpl implements GetAdditionalClientInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalClientInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalClientInfo getAdditionalClientInfo(Long id) {
        return externalServicePort.getAdditionalClientInfo(id);
    }
}
