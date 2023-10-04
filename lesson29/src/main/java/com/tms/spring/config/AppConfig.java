package com.tms.spring.config;

import com.tms.spring.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.tms.spring.service", "com.tms.spring.domain"})
public class AppConfig {
    @Bean
    Horse horse1(){
        return new Horse("horse1");
    }
    @Bean
    Horse horse2(){
        return new Horse("horse2");
    }
    @Bean
    Horse horse3(){
        return new Horse("horse3");
    }
    @Bean
    Rider rider1(){
        return new Rider("rider1");
    }
    @Bean
    Rider rider2(){
        return new Rider("rider2");
    }
    @Bean
    Rider rider3(){
        return new Rider("rider3");
    }
    @Bean
    Pair pair1(){
        return new Pair(horse1(), rider1(), 1.0, 1);
    }
    @Bean
    Pair pair2(){
        return new Pair(horse2(), rider2(), 1.0, 2);
    }
    @Bean
    Pair pair3(){
        return new Pair(horse3(), rider3(), 1.0, 3);
    }
    @Bean
    Wallet wallet(){
        return new Wallet(1000);
    }
    @Bean
    Player player(){
        return new Player("player", wallet());
    }
}
