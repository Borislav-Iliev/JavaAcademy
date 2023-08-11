package com.example.employeemvccrudexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.employeemvccrudexample.repository.*.*(..))")
    private void allMethodsInRepositories() {
    }

    @Pointcut("execution(* com.example.employeemvccrudexample.service.*.*(..))")
    private void allMethodsInServices() {
    }

    @Pointcut("execution(* com.example.employeemvccrudexample.web.*.*(..))")
    private void allMethodsInControllers() {
    }

    @Pointcut("allMethodsInRepositories() || allMethodsInServices() || allMethodsInControllers()")
    private void allMethodsInRepositoryServiceController() {
    }

    @Before("allMethodsInRepositoryServiceController()")
    public void beforeAllMethodsInRepositoryServiceController(JoinPoint joinPoint) {
        this.logger.info("Before method being called: " + joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();

        for (Object argument : args) {
            this.logger.info("Argument: " + argument);
        }
    }

    @AfterReturning(pointcut = "allMethodsInRepositoryServiceController()",
            returning = "result")
    public void afterReturningAllMethodsInRepositoryServiceController(JoinPoint joinPoint, Object result) {
        this.logger.info("After Returning method being called: " + joinPoint.getSignature().toShortString());

        this.logger.info("Result: " + result);
    }
}
