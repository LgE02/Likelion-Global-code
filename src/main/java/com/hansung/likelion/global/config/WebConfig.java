package com.hansung.likelion.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //.allowedOrigins() //특정 도메인 접속 허용

                .allowedOriginPatterns("*") //여러 패턴이 필요할 때
                .allowedOrigins("Get", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true);
    }
}
