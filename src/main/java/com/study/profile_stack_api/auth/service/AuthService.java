package com.study.profile_stack_api.auth.service;


import com.study.profile_stack_api.auth.dao.UserDao;
import com.study.profile_stack_api.auth.dto.LoginRequest;
import com.study.profile_stack_api.auth.dto.LoginResponse;
import com.study.profile_stack_api.auth.dto.SignupRequest;
import com.study.profile_stack_api.auth.dto.SingupResponse;
import com.study.profile_stack_api.auth.entity.Member;
import com.study.profile_stack_api.auth.entity.User;
import com.study.profile_stack_api.auth.entity.UserRole;
import com.study.profile_stack_api.global.exception.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SingupResponse signup(SignupRequest request){
        log.info("Signup attempt for username : {}, email: {}", request.getUsername(), request.getEmail());

        //아이디 중복 검사
        if(userDao.existsByUsername(request.getUsername())){
            throw new ApiException(ErrorCode.DUPLICATE_ID);
        }

        //이메일 중복 검사
        if(userDao.existsByEmail(request.getEmail())){
            throw new ApiException(ErrorCode.DUPLICATE_EMAIL);
        }

        //비밀번호암호화 후 저장
        User newUser = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .userRole(UserRole.USER)
                .enabled(true)
                .build();

        User savedUser = userDao.save(newUser);
        log.info("User registered successfully: {} " , savedUser.getUsername());

        return SingupResponse.of(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail()
        );
    }


    public LoginResponse login (LoginRequest request) throws UsernameNotFoundException {
        // 이름으로 유저 찾기
        Member user = userDao.findByUserName(request.getUsername())
                .orElseThrow(()-> new ApiException(ErrorCode.PROFILE_NOT_FOUND));

        //비밀번호 일치 확인
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }

        return LoginResponse.of(
                null,
                user.getUsername(),
                user.getPassword(),
                user.getUserRole().name()
        );
    }


}
