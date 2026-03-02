package com.study.profile_stack_api.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {

    private String accessToKen;
    private String username;
    private String password;
    private String userRole;


    /**
     * Static factory method
     */
    public static LoginResponse of(String accessToKen, String username, String password, String userRole) {
        return LoginResponse.builder()
                .accessToKen(accessToKen)
                .username(username)
                .password(password)
                .userRole(userRole)
                .build();
    }

    public static LoginResponse of( String username, String password, String userRole) {
        return LoginResponse.builder()

                .username(username)
                .password(password)
                .userRole(userRole)
                .build();
    }
}
