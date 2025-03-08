package com.backOffice_electric_cooperative.demo.application.usecases.merchant;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;
import com.backOffice_electric_cooperative.demo.domain.ports.input.merchant.RetrieveMerchant;
import com.backOffice_electric_cooperative.demo.domain.ports.output.MerchantRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveMerchantImpl implements RetrieveMerchant {
    private final MerchantRepositoryPort merchantRepositoryPort;

    public RetrieveMerchantImpl(MerchantRepositoryPort merchantRepositoryPort, MerchantRepositoryPort merchantRepositoryPort1) {
        this.merchantRepositoryPort = merchantRepositoryPort1;
    }

    public RetrieveMerchantImpl(MerchantRepositoryPort merchantRepositoryPort) {
        this.merchantRepositoryPort = merchantRepositoryPort;
    }

    @Override
    public Optional<Merchant> getMerchant(Long id) {
        return this.merchantRepositoryPort.findById(id);
    }

    @Override
    public List<Merchant> getAllMerchants() {
        return this.merchantRepositoryPort.findAll();
    }
}
