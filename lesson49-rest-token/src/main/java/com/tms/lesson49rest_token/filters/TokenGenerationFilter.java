package com.tms.lesson49rest_token.filters;

import com.tms.lesson49rest_token.entity.UserEntity;
import com.tms.lesson49rest_token.repository.UserRepository;
import com.tms.lesson49rest_token.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Service
public class TokenGenerationFilter extends OncePerRequestFilter {
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username != null && !username.isBlank()){
           repository.findByLogin(username).ifPresent(userEntity -> {
               if(userEntity.getPassword().equals(password)){
                   String token = tokenService.createToken(userEntity);
                   response.setHeader("jwt-token", token);
               }
           });


        }

        filterChain.doFilter(request, response);
    }
}
