package com.backOffice_electric_cooperative.demo.application.usecases.transaction;

import com.backOffice_electric_cooperative.demo.domain.models.Transaction;
import com.backOffice_electric_cooperative.demo.domain.ports.input.transaction.NewTransaction;
import com.backOffice_electric_cooperative.demo.domain.ports.output.TransactionRepositoryPort;;

public class CreateTransactionImpl implements NewTransaction{
    private final TransactionRepositoryPort transactionRepositoryPort;

    public CreateTransactionImpl(TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Override
    public Transaction newTransaction(Transaction Transaction) {
        return this.transactionRepositoryPort.save(Transaction);
    }
}
