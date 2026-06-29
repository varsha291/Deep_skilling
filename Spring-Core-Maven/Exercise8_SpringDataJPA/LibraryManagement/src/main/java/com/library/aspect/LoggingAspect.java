package com.library.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

    public void logBefore(JoinPoint joinPoint) {
        System.out.println("LOG: Method Started -> " + joinPoint.getSignature().getName());
    }

    public void logAfter(JoinPoint joinPoint) {
        System.out.println("LOG: Method Completed -> " + joinPoint.getSignature().getName());
    }
}