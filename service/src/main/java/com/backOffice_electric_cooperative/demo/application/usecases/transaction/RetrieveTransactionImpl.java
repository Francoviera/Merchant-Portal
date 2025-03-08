package com.backOffice_electric_cooperative.demo.application.usecases.transaction;

import com.backOffice_electric_cooperative.demo.domain.models.Transaction;
import com.backOffice_electric_cooperative.demo.domain.ports.input.transaction.RetrieveTransaction;
import com.backOffice_electric_cooperative.demo.domain.ports.output.TransactionRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTransactionImpl implements RetrieveTransaction {

    private final TransactionRepositoryPort transactionRepositoryPort;

    public RetrieveTransactionImpl(TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Override
    public Optional<Transaction> getTransaction(Long id) {
        return this.transactionRepositoryPort.findById(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return this.transactionRepositoryPort.findAll();
    }
}
