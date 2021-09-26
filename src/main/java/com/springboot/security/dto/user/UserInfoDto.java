package com.springboot.security.dto.user;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {

    private String email;
    private String password;
    private String auth;
    
}   
