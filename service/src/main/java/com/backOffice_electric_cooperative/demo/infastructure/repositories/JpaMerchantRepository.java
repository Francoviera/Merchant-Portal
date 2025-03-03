package com.backOffice_electric_cooperative.demo.infastructure.repositories;

import com.backOffice_electric_cooperative.demo.infastructure.entities.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMerchantRepository extends JpaRepository<MerchantEntity, Long> {
}
