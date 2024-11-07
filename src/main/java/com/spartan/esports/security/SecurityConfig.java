package com.spartan.esports.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    // SecurityFilterChain is now the preferred way to configure HTTP security
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Enable CORS with custom config
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .authorizeRequests(auth -> auth
                        .requestMatchers("/customers/**").permitAll()  // Allow access to customer-related endpoints
                        .requestMatchers("/messages/**").permitAll()   // Allow access to message-related endpoints
                        .requestMatchers("/comments/**").permitAll()   // Allow access to comment-related endpoints
                        .anyRequest().permitAll()  // Allow all other requests to be permitted without authentication
                )
                .formLogin().disable()  // Disable the default form login
                .httpBasic().disable(); // Disable HTTP Basic Authentication (use JWT or another method if needed)

        return http.build();
    }

    // CORS configuration method
    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(List.of("http://localhost:3000"));  // Frontend URL for CORS
        corsConfig.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        corsConfig.setAllowedHeaders(List.of("*"));
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }
}
