package com.zemoso.seeder.modules.user;

import com.zemoso.seeder.common.ApiResponse;
import com.zemoso.seeder.modules.user.dto.SaveUserRequest;
import com.zemoso.seeder.modules.user.dto.UserDetailResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("{user-id}")
    public ResponseEntity<ApiResponse<UserDetailResponse>> findByUserID(@PathVariable("user-id") int id) {

        ApiResponse<UserDetailResponse> response = ApiResponse.<UserDetailResponse>builder()
                .data(service.findByUserID(id))
                .message("User details fetched successfully")
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> saveUser(@Valid @RequestBody SaveUserRequest request) {
        service.saveUser(request);
        return ResponseEntity.ok(ApiResponse.builder().message("User registered successfully!").build());
    }
}
