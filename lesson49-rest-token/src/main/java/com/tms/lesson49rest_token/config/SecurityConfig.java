package com.tms.lesson49rest_token.config;

import com.tms.lesson49rest_token.filters.TokenGenerationFilter;
import com.tms.lesson49rest_token.filters.TokenValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private TokenGenerationFilter tokenGenerationFilter;
    @Autowired
    private TokenValidationFilter tokenValidationFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(cust -> {
            cust.requestMatchers("/auth").permitAll()
                    .requestMatchers("/private").authenticated()
                    .requestMatchers("/admin").hasRole("ADMIN");
        });
        http.addFilterAfter(tokenGenerationFilter, WebAsyncManagerIntegrationFilter.class);
        http.addFilterAfter(tokenValidationFilter, LogoutFilter.class);
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(AbstractHttpConfigurer::disable);
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }
}
