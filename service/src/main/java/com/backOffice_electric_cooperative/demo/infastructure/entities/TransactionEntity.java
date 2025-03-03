package com.backOffice_electric_cooperative.demo.infastructure.entities;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;
import com.backOffice_electric_cooperative.demo.domain.models.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String description;

    private String date;

    public Transaction toDomainModel(){return new Transaction(id, description, date);}

    public static TransactionEntity fromDomainInModel(Transaction transaction) {
        return new TransactionEntity(transaction.get);
    }
}
