package com.tms.spring;

import com.tms.spring.domain.Pair;
import com.tms.spring.service.HorseRacingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("my-config.xml");
        HorseRacingService horseRacingService = context.getBean(HorseRacingService.class);
        Pair pair1 = context.getBean("pair1", Pair.class);
        Pair pair2 = context.getBean("pair2", Pair.class);
        Pair pair3 = context.getBean("pair3", Pair.class);
        List<Pair> pairs = new ArrayList<>();
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        horseRacingService.startRace(pairs);
    }
}
