package com.zemoso.seeder.modules.contract;

import com.zemoso.seeder.common.BaseEntity;
import com.zemoso.seeder.modules.contract.dto.PeriodType;
import com.zemoso.seeder.modules.contract.dto.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "contract")
public class Contract extends BaseEntity {

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PeriodType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "per_payment", precision = 10, scale = 2)
    private BigDecimal perPayment;

    @Column(name = "total_financed", precision = 10, scale = 2)
    private BigDecimal totalFinanced;

    @Column(name = "total_available", precision = 10, scale = 2)
    private BigDecimal totalAvailable;

    @Column(name = "interest_rate", precision = 5, scale = 2)
    private BigDecimal interestRate;

    private int termLength;


}
