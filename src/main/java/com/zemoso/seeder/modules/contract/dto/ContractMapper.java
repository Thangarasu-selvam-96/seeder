package com.zemoso.seeder.modules.contract.dto;

import com.zemoso.seeder.modules.contract.Contract;
import org.springframework.stereotype.Service;

@Service
public class ContractMapper {

    public Contract toContract(SaveContractRequest request) {

        return Contract.builder()
                .name(request.getName())
                .type(request.getType())
                .status(request.getStatus())
                .perPayment(request.getPerPayment())
                .interestRate(request.getInterestRate())
                .totalAvailable(request.getTotalAvailable())
                .build();

    }

    public ContractResponse toContractResponse(Contract contract) {
        return ContractResponse.builder()
                .id(contract.getId())
                .name(contract.getName())
                .paymentAmount(contract.getTotalAvailable())
                .perPayment(contract.getPerPayment())
                .termLength(contract.getTermLength())
                .interestRate(contract.getInterestRate())
                .build();
    }
}
