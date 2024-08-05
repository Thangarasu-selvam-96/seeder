package com.zemoso.seeder.modules.user;

import com.zemoso.seeder.exception.BussinessException;
import com.zemoso.seeder.modules.user.dto.SaveUserRequest;
import com.zemoso.seeder.modules.user.dto.UserDetailResponse;
import com.zemoso.seeder.modules.user.dto.UserMapper;
import com.zemoso.seeder.modules.user_credit.UserCreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final UserCreditService userCreditService;


    public UserDetailResponse findByUserID(int id) {

        User user = repository.findById(id).orElseThrow(() -> new BussinessException("User does not exist"));
        return mapper.toUserDetailResponse(user);

    }

    public void saveUser(SaveUserRequest request) {

        repository.getByEmail(request.getEmail()).ifPresent(user -> {
            throw new BussinessException("Email already exists: "+ user.getEmail());
        });


        User user = mapper.toUser(request);
        repository.save(user);

        userCreditService.saveUserCredit(user);


    }
}
