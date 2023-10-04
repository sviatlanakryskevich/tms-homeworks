package com.tms.spring;

import com.tms.spring.domain.Pair;
import com.tms.spring.service.HorseRacingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms.spring.config");
        HorseRacingService horseRacingService = context.getBean(HorseRacingService.class);
        horseRacingService.startRace();
    }
}
