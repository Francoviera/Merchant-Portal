package com.backOffice_electric_cooperative.demo.domain.ports.input.merchant;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;

public interface NewMerchant {
    Merchant newMerchant(Merchant merchant);
}
