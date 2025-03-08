package com.backOffice_electric_cooperative.demo.application.usecases.transaction;

import com.backOffice_electric_cooperative.demo.domain.models.Transaction;
import com.backOffice_electric_cooperative.demo.domain.ports.input.transaction.UpdateTransaction;
import com.backOffice_electric_cooperative.demo.domain.ports.output.TransactionRepositoryPort;

import java.util.Optional;

public class UpdateTransactionImpl implements UpdateTransaction {
    private final TransactionRepositoryPort transactionRepositoryPort;

    public UpdateTransactionImpl(TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Override
    public Optional<Transaction> updateTransaction(Transaction transaction) {
        return Optional.ofNullable(this.transactionRepositoryPort.save(transaction));
    }
}
