package com.study.profile_stack_api.auth.controller;


import com.study.profile_stack_api.auth.dto.LoginRequest;
import com.study.profile_stack_api.auth.dto.SignupRequest;
import com.study.profile_stack_api.auth.dto.SingupResponse;
import com.study.profile_stack_api.auth.service.AuthService;
import com.study.profile_stack_api.global.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {


    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SingupResponse>> signup(
            @Valid @RequestBody SignupRequest request){
        log.info("Signup request for username: {} ", request.getUsername());
        SingupResponse response = authService.signup(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));

    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request){
        log.info("Login request for username :{}", request.getUsername());
        authService.login(request);
        return "🎉 로그인 성공! 환영합니다, " + request.getUsername() + "님!";
    }

    //@PostMapping("/refresh")

    //@PostMapping("/logout")
}
