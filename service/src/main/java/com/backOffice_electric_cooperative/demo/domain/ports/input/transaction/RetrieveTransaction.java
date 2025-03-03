package com.backOffice_electric_cooperative.demo.domain.ports.input.transaction;

import com.backOffice_electric_cooperative.demo.domain.models.Transaction;

import java.util.List;
import java.util.Optional;

public interface RetrieveTransaction {
    Optional<Transaction> getTransaction(Long id);
    List<Transaction> getAllTransactions();
}
