package com.example.demo.config;

import com.example.demo.utils.jwt.JWTInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * description: JWTConfig
 * date: 4/23/21 5:47 PM
 * author: fourwood
 */
@Configuration
public class JWTConfig implements WebMvcConfigurer {

    private final JWTInterceptor jwtInterceptor;

    @Autowired
    public JWTConfig(JWTInterceptor jwtInterceptor){
        this.jwtInterceptor = jwtInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/api/v1/**");
    }
}
