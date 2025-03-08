package com.backOffice_electric_cooperative.demo.domain.ports.input.user;

import com.backOffice_electric_cooperative.demo.domain.ports.input.transaction.GetAdditionalTransactionInfo;

public interface GetAdditionalUserInfo {
    GetAdditionalUserInfo getAdditionalUserInfo(Long id);
}
