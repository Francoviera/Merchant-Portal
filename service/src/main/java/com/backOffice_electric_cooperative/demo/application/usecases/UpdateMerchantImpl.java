package com.backOffice_electric_cooperative.demo.application.usecases;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;
import com.backOffice_electric_cooperative.demo.domain.ports.input.merchant.UpdateMerchant;
import com.backOffice_electric_cooperative.demo.domain.ports.output.MerchantRepositoryPort;

import java.util.Optional;

public class UpdateMerchantImpl implements UpdateMerchant {
    private final MerchantRepositoryPort merchantRepositoryPort;

    public UpdateMerchantImpl(MerchantRepositoryPort merchantRepositoryPort) {
        this.merchantRepositoryPort = merchantRepositoryPort;
    }

    @Override
    public Optional<Merchant> updateMerchant(Merchant merchant) {
        return this.merchantRepositoryPort.update(merchant);
    }
}
