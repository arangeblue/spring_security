package com.springboot.security;

import com.springboot.security.repository.user.UserRepository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    

    private final UserRepository userRepository;

    public DemoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PreAuthorize("isAuthenticated()")
    public Long save(Demo demo) {
        return userRepository.save(demo).getId();
    }
}
