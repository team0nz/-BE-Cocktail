package com.application.common.auth.config;

import com.application.common.auth.service.*;
import com.application.common.auth.jwt.JWTFilter;
import com.application.common.auth.jwt.JWTUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {

    private final JWTUtil jwtUtil;
    private final JWTAccessTokenBlackListService jwtAccessTokenBlackListService;

    public SecurityConfig(JWTUtil jwtUtil, JWTAccessTokenBlackListService jwtAccessTokenBlackListService){
        this.jwtUtil = jwtUtil;
        this.jwtAccessTokenBlackListService = jwtAccessTokenBlackListService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .csrf((auth) -> auth.disable());

        http
                .formLogin((auth) -> auth.disable());

        http
                .httpBasic((auth) -> auth.disable());

        http
                .addFilterBefore(new JWTFilter(jwtUtil, jwtAccessTokenBlackListService), UsernamePasswordAuthenticationFilter.class);


        http
                .authorizeHttpRequests((auth)->auth
                        .requestMatchers("/api/auth/refresh", "/api/auth/social-login", "/api/auth/**").permitAll()
                        .requestMatchers("/login/oauth2/code/google", "/login/oauth2/code/naver").permitAll()
                        .requestMatchers("/api/auth/naver/token", "/api/auth/google/token").permitAll()
                        .requestMatchers("/api/auth/naver/login-url", "/api/auth/google/login-url").permitAll()
                        .requestMatchers("/api/public/**").permitAll()
                        .anyRequest().authenticated());

        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build();
    }

}
