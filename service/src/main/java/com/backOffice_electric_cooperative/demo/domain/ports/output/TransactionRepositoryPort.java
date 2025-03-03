package com.backOffice_electric_cooperative.demo.domain.ports.output;

import com.backOffice_electric_cooperative.demo.domain.models.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepositoryPort {
    Transaction save(Transaction transaction);
    Optional<Transaction> findById(Long id);
    List<Transaction> findAll();
    Optional<Transaction> update (Transaction transaction);
    boolean delete(Long id);

}
