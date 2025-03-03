package com.backOffice_electric_cooperative.demo.application.usecases;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;
import com.backOffice_electric_cooperative.demo.domain.ports.input.merchant.NewMerchant;
import com.backOffice_electric_cooperative.demo.domain.ports.output.MerchantRepositoryPort;

public class CreateMerchantImpl implements NewMerchant {
    private final MerchantRepositoryPort merchantRepositoryPort;

    public CreateMerchantImpl(MerchantRepositoryPort merchantRepositoryPort) {
        this.merchantRepositoryPort = merchantRepositoryPort;
    }

    @Override
    public Merchant newMerchant(Merchant merchant) {
        return this.merchantRepositoryPort.save(merchant);
    }
}
