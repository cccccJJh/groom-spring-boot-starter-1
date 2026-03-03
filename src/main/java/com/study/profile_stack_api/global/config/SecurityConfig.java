package com.study.profile_stack_api.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.web.servlet.function.RequestPredicates.headers;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 설정을 활성화합니다.
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt라는 알고리즘을 사용하는 암호화 도구를 스프링 빈으로 등록합니다.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                /*
                .authorizeHttpRequests(auth -> auth
                        //GET 요청은 무조건 통과
                        .requestMatchers(org.springframework.http.HttpMethod.GET, "/api/v1/**").permitAll()

                        //회원가입과 로그인도 누구나 접근 가능해야 함
                        .requestMatchers("/api/v1/auth/**").permitAll()

                        //나머지
                        .anyRequest().authenticated())
*/
                        //임시용~~~~~~~~~~~₩
                        .authorizeHttpRequests(auth -> auth
                                .anyRequest().permitAll()
                )
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));

        return http.build();
    }

}
