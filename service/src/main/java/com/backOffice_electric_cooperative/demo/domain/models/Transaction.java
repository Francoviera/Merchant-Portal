package com.backOffice_electric_cooperative.demo.domain.models;

import java.util.List;

public class Transaction {
    private final long id;

    private final String date;

    private final String description;

    public Transaction(long id, String date, String description) {
        this.id = id;
        this.date = date;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
