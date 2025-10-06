package com.ohyeahsaas.nexus.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean @Order(1)
    SecurityFilterChain h2(HttpSecurity http) throws Exception {
        http
                .securityMatcher(PathRequest.toH2Console())                 // /h2-console/**
                .authorizeHttpRequests(a -> a.anyRequest().permitAll())
                .csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()))
                .headers(h -> h.frameOptions(f -> f.sameOrigin()));
        return http.build();
    }

    @Bean @Order(2)
    SecurityFilterChain app(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(a -> a
                        .requestMatchers("/actuator/**","/v3/api-docs/**",
                                "/swagger-ui.html","/swagger-ui/**",
                                "/api/v1/ping", "/api/v1/all").permitAll()
                        .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .httpBasic(b -> {});
        return http.build();
    }
}
