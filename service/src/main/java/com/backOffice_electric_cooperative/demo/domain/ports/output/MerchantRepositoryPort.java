package com.backOffice_electric_cooperative.demo.domain.ports.output;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantRepositoryPort {
    Merchant save(Merchant merchant);
    Optional<Merchant> findById(Long id);
    List<Merchant> findAll();
    Optional<Merchant> update (Merchant merchant);
    boolean delete(Long id);
}
