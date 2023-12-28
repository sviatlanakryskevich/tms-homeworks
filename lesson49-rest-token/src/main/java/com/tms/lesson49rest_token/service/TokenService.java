package com.tms.lesson49rest_token.service;

import com.tms.lesson49rest_token.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenService {
    @Value("${project.secretkey}")
    private String secret;
    private SecretKey secretKey;

    @PostConstruct
    public void init(){
        secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }
    public String createToken(UserEntity userEntity){
        String username = userEntity.getUsername();
        String phoneNumber = userEntity.getPhoneNumber();
        Collection<? extends GrantedAuthority> authorities = userEntity.getAuthorities();

        String perms = authorities.stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(username)
                .claim("login", username)
                .claim("phone", phoneNumber)
                .claim("roles", perms)
                .signWith(secretKey)
                .compact();
    }

    public Authentication fromToken(String token){
        JwtParser parser = Jwts.parser()
                .setSigningKey(secretKey)
                .build();
        Claims payload = parser.parseClaimsJws(token).getPayload();
        Object login = payload.get("login");
        String roles = (String) payload.get("roles");
        List<SimpleGrantedAuthority> collect = Arrays.stream(roles.split(","))
                .map(s -> new SimpleGrantedAuthority(s))
                .collect(Collectors.toList());

        Object phone = payload.get("phone");
        return new UsernamePasswordAuthenticationToken(login, null, collect);
    }
}

