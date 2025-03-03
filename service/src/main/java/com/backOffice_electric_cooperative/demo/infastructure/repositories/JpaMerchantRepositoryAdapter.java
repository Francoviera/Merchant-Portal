package com.backOffice_electric_cooperative.demo.infastructure.repositories;

import com.backOffice_electric_cooperative.demo.domain.models.Merchant;
import com.backOffice_electric_cooperative.demo.domain.ports.output.ClientRepositoryPort;
import com.backOffice_electric_cooperative.demo.domain.ports.output.MerchantRepositoryPort;
import com.backOffice_electric_cooperative.demo.infastructure.entities.MerchantEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaMerchantRepositoryAdapter implements MerchantRepositoryPort {
    private final JpaMerchantRepository jpaMerchantRepository;

    public JpaMerchantRepositoryAdapter(JpaMerchantRepository jpaMerchantRepository) {
        this.jpaMerchantRepository = jpaMerchantRepository;
    }

    @Override
    public Merchant save(Merchant merchant) {
        MerchantEntity merchantEntity = MerchantEntity.fromDomainInModel(merchant);
        MerchantEntity merchantEntitySaved= this.jpaMerchantRepository.save(merchantEntity);
        return merchantEntitySaved.toDomainModel();
    }

    @Override
    public Optional<Merchant> findById(Long id) {
        return this.jpaMerchantRepository.findById(id)
                .map(MerchantEntity::toDomainModel);
    }

    @Override
    public List<Merchant> findAll() {
        return this.jpaMerchantRepository.findAll().stream()
                .map(MerchantEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Merchant> update(Merchant merchant) {
        if(jpaMerchantRepository.existsById(merchant.getId())) {
            MerchantEntity merchantEntity = MerchantEntity.fromDomainInModel(merchant);
            MerchantEntity merchantEntityUpdated = this.jpaMerchantRepository.save(merchantEntity);
            return Optional.of(merchantEntityUpdated.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if (jpaMerchantRepository.existsById(id)) {
            this.jpaMerchantRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
