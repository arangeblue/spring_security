package com.springboot.security.service.user;

import com.springboot.security.domain.user.UserInfo;
import com.springboot.security.dto.user.UserInfoDto;
import com.springboot.security.repository.user.UserRepository;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    
    private final UserRepository userRepository;

    @Override
    public UserInfo loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException((email)));
    }

    /**
   * 회원정보 저장
   *
   * @param infoDto 회원정보가 들어있는 DTO
   * @return 저장되는 회원의 PK
   */
  public Long save(UserInfoDto infoDto) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    infoDto.setPassword(encoder.encode(infoDto.getPassword()));

    return userRepository.save(UserInfo.builder()
        .email(infoDto.getEmail())
        .auth(infoDto.getAuth())
        .password(infoDto.getPassword()).build()).getCode();
  }	
}
