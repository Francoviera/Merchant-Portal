package com.backOffice_electric_cooperative.demo.application.services;

import com.backOffice_electric_cooperative.demo.domain.models.Transaction;
import com.backOffice_electric_cooperative.demo.domain.ports.input.merchant.*;
import com.backOffice_electric_cooperative.demo.domain.ports.input.transaction.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements DeleteTransaction, NewTransaction, RetrieveTransaction, UpdateTransaction, GetAdditionalTransactionInfo {
    private final DeleteTransaction deleteTransactionImpl;
    private final NewTransaction newTransactionImpl;
    private final RetrieveTransaction retrieveTransactionImpl;
    private final GetAdditionalTransactionInfo getAdditionalTransactionInfoImpl;
    private final UpdateTransaction updateTransactionImpl;

    public TransactionService(DeleteTransaction deleteTransactionImpl, NewTransaction newTransactionImpl, RetrieveTransaction retrieveTransactionImpl, GetAdditionalTransactionInfo getAdditionalTransactionInfoImpl, UpdateTransaction updateTransactionImpl) {
        this.deleteTransactionImpl = deleteTransactionImpl;
        this.newTransactionImpl = newTransactionImpl;
        this.retrieveTransactionImpl = retrieveTransactionImpl;
        this.getAdditionalTransactionInfoImpl = getAdditionalTransactionInfoImpl;
        this.updateTransactionImpl = updateTransactionImpl;
    }


    @Override
    public boolean deleteTransaction(Long id) {
        return this.deleteTransactionImpl.deleteTransaction(id);
    }

    @Override
    public GetAdditionalTransactionInfo getAdditionalTransactionInfo(Long id) {
        return this.getAdditionalTransactionInfoImpl.getAdditionalTransactionInfo(id);
    }

    @Override
    public Transaction newTransaction(Transaction Transaction) {
        return this.newTransactionImpl.newTransaction(Transaction);
    }

    @Override
    public Optional<Transaction> getTransaction(Long id) {
        return this.retrieveTransactionImpl.getTransaction(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return this.retrieveTransactionImpl.getAllTransactions();
    }

    @Override
    public Optional<Transaction> updateTransaction(Transaction transaction) {
        return this.updateTransactionImpl.updateTransaction(transaction);
    }
}
