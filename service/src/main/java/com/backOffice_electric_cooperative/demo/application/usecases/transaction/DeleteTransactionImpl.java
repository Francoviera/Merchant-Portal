package com.backOffice_electric_cooperative.demo.application.usecases.transaction;

import com.backOffice_electric_cooperative.demo.domain.ports.input.transaction.DeleteTransaction;
import com.backOffice_electric_cooperative.demo.domain.ports.output.TransactionRepositoryPort;

public class DeleteTransactionImpl implements DeleteTransaction {
    private final TransactionRepositoryPort transactionRepositoryPort;

    public DeleteTransactionImpl(TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Override
    public boolean deleteTransaction(Long id) {
        return this.transactionRepositoryPort.delete(id);
    }
}
