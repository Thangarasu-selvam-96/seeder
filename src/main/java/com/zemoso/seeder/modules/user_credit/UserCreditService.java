package com.zemoso.seeder.modules.user_credit;

import com.zemoso.seeder.modules.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserCreditService {

    private final UserCreditRepository repository;

    @Value("${application.user.user-credit}")
    public BigDecimal availableCredit;

    @Value("${application.user.term-cap}")
    public int termCap;

    @Value("${application.user.max-interest-rate}")
    public BigDecimal maxIntresetRate;

    public void saveUserCredit(User user) {

        UserCredit userCredit = UserCredit.builder()
                .availableCredit(availableCredit)
                .termCap(termCap)
                .maxInterestRate(maxIntresetRate)
                .user(user)
                .build();

        repository.save(userCredit);
    }
}
