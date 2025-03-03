package com.backOffice_electric_cooperative.demo.infastructure.config;

import com.backOffice_electric_cooperative.demo.application.services.ClientService;
import com.backOffice_electric_cooperative.demo.application.services.MerchantService;
import com.backOffice_electric_cooperative.demo.application.services.TransactionService;
import com.backOffice_electric_cooperative.demo.application.usecases.*;
import com.backOffice_electric_cooperative.demo.domain.ports.input.client.GetAdditionalClientInfoUseCase;
import com.backOffice_electric_cooperative.demo.domain.ports.input.merchant.GetAdditionalMerchantInfo;
import com.backOffice_electric_cooperative.demo.domain.ports.input.transaction.GetAdditionalTransactionInfo;
import com.backOffice_electric_cooperative.demo.domain.ports.output.ClientRepositoryPort;
import com.backOffice_electric_cooperative.demo.domain.ports.output.MerchantRepositoryPort;
import com.backOffice_electric_cooperative.demo.domain.ports.output.TransactionRepositoryPort;
import com.backOffice_electric_cooperative.demo.domain.ports.output.ExternalServicePort;
import com.backOffice_electric_cooperative.demo.domain.ports.output.MerchantRepositoryPort;
import com.backOffice_electric_cooperative.demo.domain.ports.output.TransactionRepositoryPort;
import com.backOffice_electric_cooperative.demo.infastructure.adapters.ExternalServiceAdapter;
import com.backOffice_electric_cooperative.demo.infastructure.repositories.JpaClientRepositoryAdapter;
import com.backOffice_electric_cooperative.demo.infastructure.repositories.JpaMerchantRepositoryAdapter;
import com.backOffice_electric_cooperative.demo.infastructure.repositories.JpaTransactionRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ApplicationConfig {
    @Bean
    public TransactionService transactionService(TransactionRepositoryPort transactionRepositoryPort,
                                                 @Lazy GetAdditionalClientInfoUseCase getAdditionalClientInfoUseCase, GetAdditionalTransactionInfo getAdditionalTransactionInfo){
        return new TransactionService(
                new DeleteTransactionImpl(transactionRepositoryPort),
                new CreateTransactionImpl(transactionRepositoryPort),
                new RetrieveTransactionImpl(transactionRepositoryPort),
                getAdditionalTransactionInfo,
                new UpdateTransactionImpl(transactionRepositoryPort)
        );
    }

    @Bean
    public MerchantService merchantService(MerchantRepositoryPort merchantRepositoryPort,
                                           @Lazy GetAdditionalMerchantInfo getAdditionalMerchantInfoUseCase){
        return new MerchantService(
                new DeleteMerchantImpl(merchantRepositoryPort),
                new CreateMerchantImpl(merchantRepositoryPort),
                new RetrieveMerchantImpl(merchantRepositoryPort),
                new UpdateMerchantImpl(merchantRepositoryPort),
                getAdditionalMerchantInfoUseCase
        );
    }

    @Bean
    public ClientService clientService(ClientRepositoryPort clientRepositoryPort,
                                       @Lazy GetAdditionalClientInfoUseCase getAdditionalClientInfoUseCase){
        return new ClientService(
                new CreateClientImpl(clientRepositoryPort),
                new RetrieveClientImpl(clientRepositoryPort),
                new UpdateClientImpl(clientRepositoryPort),
                new DeleteClientImpl(clientRepositoryPort),
                getAdditionalClientInfoUseCase
        );
    }
    @Bean
    public ClientRepositoryPort clientRepositoryPort(JpaClientRepositoryAdapter jpaClientRepositoryAdapter){
        return jpaClientRepositoryAdapter;
    }
    @Bean
    public MerchantRepositoryPort merchantRepositoryPort(JpaMerchantRepositoryAdapter jpaMerchantRepositoryAdapter){
        return jpaMerchantRepositoryAdapter;
    }
    @Bean
    public TransactionRepositoryPort transactionRepositoryPort(JpaTransactionRepositoryAdapter jpaTransactionRepositoryAdapter){
        return jpaTransactionRepositoryAdapter;
    }
    @Bean
    public GetAdditionalClientInfoUseCase getAdditionalClientInfoUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalClientInfoUseCaseImpl(externalServicePort);
    }
    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }
}
