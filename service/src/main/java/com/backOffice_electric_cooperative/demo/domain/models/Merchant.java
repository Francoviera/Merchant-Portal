package com.backOffice_electric_cooperative.demo.domain.models;

import java.util.List;

public class Merchant {
    private final long id;

    private final String name;

    private final String address;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    private final String phone;


    public Merchant(long id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
