package com.zemoso.seeder.modules.contract;

import com.zemoso.seeder.common.ApiResponse;
import com.zemoso.seeder.common.PageResponse;
import com.zemoso.seeder.modules.contract.dto.ContractResponse;
import com.zemoso.seeder.modules.contract.dto.SaveContractRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contract")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> saveContract(@Valid @RequestBody SaveContractRequest request) {
        service.saveContract(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<ContractResponse>>> findAllContracts(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(ApiResponse.<PageResponse<ContractResponse>>builder().data(service.findAllContracts(page, size)).build());
    }
}
