package com.zemoso.seeder.modules.user.dto;

import com.zemoso.seeder.modules.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toUser(SaveUserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Role.borrower)
                .build();
    }

    public UserDetailResponse toUserDetailResponse(User user) {
        return UserDetailResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .availableCredit(user.getUserCredit().getAvailableCredit())
                .termCap(user.getUserCredit().getTermCap())
                .maxInterestRate(user.getUserCredit().getMaxInterestRate())
                .build();
    }

}
