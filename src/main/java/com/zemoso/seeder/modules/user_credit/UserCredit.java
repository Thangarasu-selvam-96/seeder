package com.zemoso.seeder.modules.user_credit;

import com.zemoso.seeder.common.BaseEntity;
import com.zemoso.seeder.modules.user.User;
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
@Table(name = "user_credit")
public class UserCredit extends BaseEntity {

    @Column(name = "available_credit", precision = 10, scale = 2)
    private BigDecimal availableCredit;

    @Column(name = "term_cap")
    private int termCap;

    @Column(name = "max_interest_rate", precision = 5, scale = 2)
    private BigDecimal maxInterestRate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
