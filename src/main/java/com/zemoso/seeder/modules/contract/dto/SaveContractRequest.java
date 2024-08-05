package com.zemoso.seeder.modules.contract.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveContractRequest {

    @NotNull(message = "Name is mandatory")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    private String name;

    @NotNull(message = "Type is mandatory")
    @Enumerated(EnumType.STRING)
    private PeriodType type;

    @NotNull(message = "Status is mandatory")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull(message = "Per payment is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Per payment must be greater than 0")
    private BigDecimal perPayment;

    @NotNull(message = "Total available is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Total available must be greater than 0")
    private BigDecimal totalAvailable;

    @NotNull(message = "Interest is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Interest must be greater than 0")
    private BigDecimal interestRate;

}
