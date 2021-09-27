package com.springboot.security.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class SecurityMessageConfig {
    
    @Bean
    public MessageSource messageSource() {
        Locale.setDefault(Locale.KOREA); // 위치 설정
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    
        messageSource.setDefaultEncoding("UTF-8"); // 인코딩 정보 설정
        messageSource.setBasenames("classpath:message/security_message", // 메시지 설정파일 설정.
                "classpath:org/springframework/security/messages");
        return messageSource;
    }
}
