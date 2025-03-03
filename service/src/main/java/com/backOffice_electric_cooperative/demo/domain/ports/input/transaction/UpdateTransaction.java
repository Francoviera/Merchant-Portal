package com.backOffice_electric_cooperative.demo.domain.ports.input.transaction;

import com.backOffice_electric_cooperative.demo.domain.models.Transaction;

import java.util.Optional;

public interface UpdateTransaction {
    Optional<Transaction> updateTransaction(Transaction transaction);
}
