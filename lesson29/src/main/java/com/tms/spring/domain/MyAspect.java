package com.tms.spring.domain;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Pointcut("@annotation(com.tms.spring.domain.Benchmark)")
    void myPointCut(){
    }

    @Around("myPointCut()")
    public void doAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        String name = joinPoint.getSignature().getName();
        System.out.println("Time of execution " + name +"is - " + (end - start) + " milliseconds");
    }
}
