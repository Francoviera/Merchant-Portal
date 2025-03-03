package com.backOffice_electric_cooperative.demo.domain.ports.input.transaction;

import com.backOffice_electric_cooperative.demo.domain.models.Transaction;

public interface NewTransaction {
    Transaction newTransaction(Transaction Transaction);
}
