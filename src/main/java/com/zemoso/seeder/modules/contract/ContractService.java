package com.zemoso.seeder.modules.contract;

import com.zemoso.seeder.common.PageResponse;
import com.zemoso.seeder.modules.contract.dto.ContractMapper;
import com.zemoso.seeder.modules.contract.dto.ContractResponse;
import com.zemoso.seeder.modules.contract.dto.SaveContractRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository repository;
    private final ContractMapper mapper;

    public void saveContract(SaveContractRequest request) {
        repository.save(mapper.toContract(request));
    }

    public PageResponse<ContractResponse> findAllContracts(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Contract> contracts = repository.findAll(pageable);

        List<ContractResponse> contractResponse = contracts.stream().map(mapper::toContractResponse).toList();

        return PageResponse.<ContractResponse>builder()
                .content(contractResponse)
                .number(contracts.getNumber())
                .size(contracts.getSize())
                .totalElements(contracts.getTotalElements())
                .first(contracts.isFirst())
                .last(contracts.isLast())
                .build();

    }
}
