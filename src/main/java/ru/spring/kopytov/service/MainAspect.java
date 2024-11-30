package ru.spring.kopytov.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class MainAspect {

    private final Logger logger;

    public MainAspect(Logger logger) {
        this.logger = logger;
    }

    @Around("@annotation(LogController)")
    public Object logControllerAround(ProceedingJoinPoint joinPoint) {
        Level level = logger.getLevel();
        logger.log(level, "Start controller method: " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            logger.log(level, "with args: " + Arrays.toString(args));
        }
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        logger.log(level, "Output args: ");
        logger.log(level, result.toString());
        logger.log(level, "End controller method: " + joinPoint.getSignature().getName());
        return result;
    }
}
