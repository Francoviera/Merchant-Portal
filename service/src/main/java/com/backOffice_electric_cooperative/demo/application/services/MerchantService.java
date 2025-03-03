package com.backOffice_electric_cooperative.demo.application.services;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;
import com.backOffice_electric_cooperative.demo.domain.ports.input.client.*;
import com.backOffice_electric_cooperative.demo.domain.ports.input.merchant.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantService implements DeleteMerchant, NewMerchant, RetrieveMerchant, UpdateMerchant, GetAdditionalMerchantInfo {
    private final DeleteMerchant deleteMerchantImpl;
    private final NewMerchant newMerchantImpl;
    private final RetrieveMerchant retrieveMerchantImpl;
    private final UpdateMerchant updateMerchantImpl;
    private final GetAdditionalMerchantInfo getAdditionalMerchantInfoImpl;

    public MerchantService(DeleteMerchant deleteMerchantImpl, NewMerchant newMerchantImpl, RetrieveMerchant retrieveMerchantImpl, UpdateMerchant updateMerchantImpl, GetAdditionalMerchantInfo getAdditionalMerchantInfoImpl) {
        this.deleteMerchantImpl = deleteMerchantImpl;
        this.newMerchantImpl = newMerchantImpl;
        this.retrieveMerchantImpl = retrieveMerchantImpl;
        this.updateMerchantImpl = updateMerchantImpl;
        this.getAdditionalMerchantInfoImpl = getAdditionalMerchantInfoImpl;
    }

    @Override
    public GetAdditionalMerchantInfo getAdditionalMerchantInfo(Long id) {
        return this.getAdditionalMerchantInfoImpl.getAdditionalMerchantInfo(id);
    }

    @Override
    public Optional<Merchant> getMerchant(Long id) {
        return this.retrieveMerchantImpl.getMerchant(id);
    }

    @Override
    public List<Merchant> getAllMerchants() {
        return this.retrieveMerchantImpl.getAllMerchants();
    }

    @Override
    public boolean deleteMerchant(Long id) {
        return this.deleteMerchantImpl.deleteMerchant(id);
    }

    @Override
    public Optional<Merchant> updateMerchant(Merchant merchant) {
        return this.updateMerchantImpl.updateMerchant(merchant);
    }

    @Override
    public Merchant newMerchant(Merchant merchant) {
        return this.newMerchantImpl.newMerchant(merchant);
    }
}
