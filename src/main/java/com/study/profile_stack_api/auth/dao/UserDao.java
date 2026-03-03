package com.study.profile_stack_api.auth.dao;


import com.study.profile_stack_api.auth.entity.User;
import com.study.profile_stack_api.auth.entity.UserRole;
import com.study.profile_stack_api.auth.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Optional;

public interface UserDao {

    public Optional<Member> findByUserName(String username) ;

    public boolean existsByUsername(String username);

    public boolean existsByEmail(String email);

    public Optional<User> findById(Long id) ;

    // ---- save --
    public User save(User user);
}
