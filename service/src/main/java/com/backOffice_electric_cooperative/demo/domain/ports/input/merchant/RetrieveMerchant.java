package com.backOffice_electric_cooperative.demo.domain.ports.input.merchant;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;

import java.util.List;
import java.util.Optional;

public interface RetrieveMerchant {
    Optional<Merchant> getMerchant(Long id);
    List<Merchant> getAllMerchants();
}
