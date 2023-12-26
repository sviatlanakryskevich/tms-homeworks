package com.tms.lesson47security.config;

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

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(cust -> {
            cust.requestMatchers("/public", "/register", "/login", "/logout", "/welcome").permitAll()
                    .requestMatchers("/private").authenticated()
                    .requestMatchers("/access").hasAuthority("access");
        });
        http.formLogin(cust -> {
            cust.loginPage("/public");
            cust.loginProcessingUrl("/login");
            cust.usernameParameter("login");
            cust.passwordParameter("cred");
            cust.successHandler(((request, response, authentication) -> {
                response.sendRedirect("/private");
            }));
            cust.failureHandler(((request, response, exception) -> {
                response.sendRedirect("/public");
            }));
        });
        http.logout(cust -> {
            cust.logoutUrl("/logout");
            cust.logoutSuccessUrl("/welcome");
            cust.invalidateHttpSession(true);

        });
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(AbstractHttpConfigurer::disable);
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /*@Bean
    public UserDetailsManager userDetailsManager(){
        UserDetails user1 = User.builder().username("user1").password("pass1").build();
        UserDetails user2 = User.builder().username("user2").password("pass2").authorities("access").build();
        UserDetails user3 = User.builder().username("user3").password("pass3").build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
