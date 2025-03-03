package com.backOffice_electric_cooperative.demo.infastructure.repositories;

import com.backOffice_electric_cooperative.demo.domain.models.Transaction;
import com.backOffice_electric_cooperative.demo.domain.ports.output.TransactionRepositoryPort;
import com.backOffice_electric_cooperative.demo.infastructure.entities.MerchantEntity;
import com.backOffice_electric_cooperative.demo.infastructure.entities.TransactionEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaTransactionRepositoryAdapter implements TransactionRepositoryPort {
    private final JpaTransactionRepository jpaTransactionRepository;

    public JpaTransactionRepositoryAdapter(JpaTransactionRepository jpaTransactionRepository) {
        this.jpaTransactionRepository = jpaTransactionRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity transactionEntity = TransactionEntity.fromDomainInModel(transaction);
        TransactionEntity transactionEntitySaved= jpaTransactionRepository.save(transactionEntity);
        return transactionEntitySaved.toDomainModel();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return this.jpaTransactionRepository.findById(id)
                .map(TransactionEntity::toDomainModel);
    }

    @Override
    public List<Transaction> findAll() {
        return this.jpaTransactionRepository.findAll().stream()
                .map(TransactionEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Transaction> update(Transaction transaction) {
        if(jpaTransactionRepository.existsById(transaction.getId())) {
            TransactionEntity transactionEntity = TransactionEntity.fromDomainInModel(transaction);
            TransactionEntity transactionEntityUpdated = this.jpaTransactionRepository.save(transactionEntity);
            return Optional.of(transactionEntityUpdated.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if(jpaTransactionRepository.existsById(id)) {
            this.jpaTransactionRepository.deleteById(id);
            return true;
        }
            return false;
    }
}
