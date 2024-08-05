package com.zemoso.seeder.modules.contract.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractResponse {

    private int id;
    private String name;
    private PeriodType type;
    private BigDecimal perPayment;
    private int termLength;
    private BigDecimal paymentAmount;
    private BigDecimal interestRate;

}
