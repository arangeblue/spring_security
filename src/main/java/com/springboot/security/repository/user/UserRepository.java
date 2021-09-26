package com.springboot.security.repository.user;

import java.util.Optional;

import com.springboot.security.domain.user.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    
    Optional<UserInfo> findByEmail(String email);
}
