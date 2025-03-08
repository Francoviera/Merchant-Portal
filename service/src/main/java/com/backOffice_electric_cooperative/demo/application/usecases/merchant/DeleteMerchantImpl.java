package com.backOffice_electric_cooperative.demo.application.usecases.merchant;

import com.backOffice_electric_cooperative.demo.domain.ports.input.merchant.DeleteMerchant;
import com.backOffice_electric_cooperative.demo.domain.ports.output.MerchantRepositoryPort;

public class DeleteMerchantImpl implements DeleteMerchant {
    private final MerchantRepositoryPort merchantRepositoryPort;

    public DeleteMerchantImpl(MerchantRepositoryPort merchantRepositoryPort) {
        this.merchantRepositoryPort = merchantRepositoryPort;
    }

    @Override
    public boolean deleteMerchant(Long id) {
        return this.merchantRepositoryPort.delete(id);
    }
}
