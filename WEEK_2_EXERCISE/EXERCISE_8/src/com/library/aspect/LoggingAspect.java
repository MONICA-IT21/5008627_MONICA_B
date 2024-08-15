package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.library.service.BookServiceImpl.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        LOGGER.info("Before executing method: {}", joinPoint.getSignature().getName());
    }

    @After("execution(* com.library.service.BookServiceImpl.*(..))")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        LOGGER.info("After executing method: {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.library.service.BookServiceImpl.*(..))", throwing = "e")
    public void logAfterMethodExecutionWithException(JoinPoint joinPoint, Throwable e) {
        LOGGER.error("An exception occurred in method: {}", joinPoint.getSignature().getName(), e);
    }
}