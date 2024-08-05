package com.zemoso.seeder.modules.user.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailResponse {

    private String name;
    private String email;
    private int termCap;
    private BigDecimal availableCredit;
    private BigDecimal maxInterestRate;

}
