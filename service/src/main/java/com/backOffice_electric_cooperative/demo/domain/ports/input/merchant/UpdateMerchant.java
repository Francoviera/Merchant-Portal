package com.backOffice_electric_cooperative.demo.domain.ports.input.merchant;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;

import java.util.Optional;

public interface UpdateMerchant {
    Optional<Merchant> updateMerchant(Merchant merchant);
}
