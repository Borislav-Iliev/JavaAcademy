package com.example.aopexample.aspect;

import com.example.aopexample.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(1)
@Component
public class MyLoggingAspect {

    @Before("com.example.aopexample.aspect.Pointcuts.anyMethodInServicePackageWithoutGettersAndSetters()")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getSimpleName() + ": Before Adding an Account");
    }

    @AfterReturning(pointcut = "execution(public * com.example.aopexample.service.AccountService.findAllAccounts(..))",
            returning = "accounts")
    public void afterReturningFindAllAccounts(JoinPoint joinPoint, List<Account> accounts) {
        System.out.println("After returning: " + joinPoint.getSignature().toShortString());
        System.out.println("After returning: " + accounts);
        accounts.forEach(a -> a.setName(a.getName().toUpperCase()));
    }

    @AfterThrowing(pointcut = "execution(public * com.example.aopexample.service.AccountService.findAllAccountsWithException(..))",
            throwing = "ex")
    public void afterThrowingFindAllAccounts(JoinPoint joinPoint, RuntimeException ex) {
        System.out.println("After throwing: " + joinPoint.getSignature().toShortString());
        System.out.println("After throwing: " + ex.getMessage());
    }

    @After("com.example.aopexample.aspect.Pointcuts.anyMethodInServicePackageWithoutGettersAndSetters()")
    public void afterAddAccount(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getSimpleName() + ": After Adding an Account");
    }

    @Around("execution(public * com.example.aopexample.service.AccountService.addAccount(..))")
    public Object aroundAddAccount(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("Duration for execution: " + duration / 1000.0);

        return result;
    }
}
