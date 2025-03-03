package com.backOffice_electric_cooperative.demo.infastructure.entities;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "merchants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MerchantEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    private String address;

    private String phone;

    //private List<ClientEntity> clients;
    public Merchant toDomainModel(){return new Merchant(id, name, address, phone);}

    public static MerchantEntity fromDomainInModel(Merchant merchant) {
        return new MerchantEntity(merchant.getId(), merchant.getName(), merchant.getAddress(), merchant.getPhone());
    }
}
