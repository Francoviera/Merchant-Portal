package com.backOffice_electric_cooperative.demo.infastructure.config;

import com.backOffice_electric_cooperative.demo.application.services.*;
import com.backOffice_electric_cooperative.demo.application.usecases.client.*;
import com.backOffice_electric_cooperative.demo.application.usecases.merchant.CreateMerchantImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.merchant.DeleteMerchantImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.merchant.RetrieveMerchantImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.merchant.UpdateMerchantImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.transaction.CreateTransactionImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.transaction.DeleteTransactionImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.transaction.RetrieveTransactionImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.transaction.UpdateTransactionImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.user.CreateUserImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.user.DeleteUserImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.user.RetrieveUserImpl;
import com.backOffice_electric_cooperative.demo.application.usecases.user.UpdateUserImpl;
import com.backOffice_electric_cooperative.demo.domain.ports.input.client.GetAdditionalClientInfoUseCase;
import com.backOffice_electric_cooperative.demo.domain.ports.input.merchant.GetAdditionalMerchantInfo;
import com.backOffice_electric_cooperative.demo.domain.ports.input.transaction.GetAdditionalTransactionInfo;
import com.backOffice_electric_cooperative.demo.domain.ports.input.user.GetAdditionalUserInfo;
import com.backOffice_electric_cooperative.demo.domain.ports.output.*;
import com.backOffice_electric_cooperative.demo.infastructure.adapters.ExternalServiceAdapter;
import com.backOffice_electric_cooperative.demo.infastructure.repositories.JpaClientRepositoryAdapter;
import com.backOffice_electric_cooperative.demo.infastructure.repositories.JpaMerchantRepositoryAdapter;
import com.backOffice_electric_cooperative.demo.infastructure.repositories.JpaTransactionRepositoryAdapter;
import com.backOffice_electric_cooperative.demo.infastructure.repositories.JpaUserRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public JwtService jwtService(){
        return new JwtService();
    }
    @Bean
    public AuthenticationService authenticationService(
            UserRepositoryPort userRepositoryPort,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager
    ){
        return new AuthenticationService(
                userRepositoryPort,
                passwordEncoder,
                jwtService,
                authenticationManager
        );
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); // Use your custom UserDetailsService
        authProvider.setPasswordEncoder(passwordEncoder()); // Use a password encoder (BCrypt)
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Encrypt passwords using BCrypt
    }
    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort,
                                   @Lazy GetAdditionalUserInfo getAdditionalUserInfoUseCase){
        return new UserService(
                new DeleteUserImpl(userRepositoryPort),
                new CreateUserImpl(userRepositoryPort),
                new UpdateUserImpl(userRepositoryPort),
                new RetrieveUserImpl(userRepositoryPort),
                getAdditionalUserInfoUseCase
        );
    }

    @Bean
    public TransactionService transactionService(
            TransactionRepositoryPort transactionRepositoryPort,
            @Lazy GetAdditionalTransactionInfo getAdditionalTransactionInfo){
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
    public UserRepositoryPort userRepositoryPort(JpaUserRepositoryAdapter jpaUserRepositoryAdapter){
        return jpaUserRepositoryAdapter;
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
