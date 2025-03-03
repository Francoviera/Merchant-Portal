package com.backOffice_electric_cooperative.demo.infastructure.controllers;

import com.backOffice_electric_cooperative.demo.application.services.ClientService;
import com.backOffice_electric_cooperative.demo.application.services.MerchantService;
import com.backOffice_electric_cooperative.demo.application.services.TransactionService;
import com.backOffice_electric_cooperative.demo.domain.models.Client;
import com.backOffice_electric_cooperative.demo.domain.models.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createTransaction= transactionService.newTransaction(transaction);
        return new ResponseEntity<>(createTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getMerchant(@PathVariable Long transactionId) {
        return transactionService.getTransaction(transactionId)
                .map(transaction -> new ResponseEntity<>(transaction, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @PutMapping("/{transactionId}")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
        return transactionService.updateTransaction(transaction)
                .map(transaction1 -> new ResponseEntity<>(transaction1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long transactionId) {
        if(transactionService.deleteTransaction(transactionId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
