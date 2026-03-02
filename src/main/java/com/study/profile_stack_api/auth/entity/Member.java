package com.study.profile_stack_api.auth.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long id;
    private String username;
    private String password;
    private UserRole userRole;
    private LocalDateTime createdAt;
}
