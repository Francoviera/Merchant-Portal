package com.backOffice_electric_cooperative.demo.infastructure.entities;


import com.backOffice_electric_cooperative.demo.domain.models.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "clients")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String phone;

    private String address;

    public Client toDomainModel(){
        return new Client(id,name,email,phone,address);
    }

    public static ClientEntity fromDomainInModel(Client client){
        return new ClientEntity(client.getId(), client.getName(), client.getEmail(), client.getPhone(), client.getAdress());
    }
}