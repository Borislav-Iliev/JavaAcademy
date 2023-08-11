package com.example.aopexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Pointcuts {

    @Pointcut("execution(public * com.example.aopexample.service.*.*(..))")
    public void anyMethodInServicePackage() {}

    @Pointcut("execution(public * com.example.aopexample.service.*.get*(..))")
    public void gettersInServicePackage() {}

    @Pointcut("execution(public * com.example.aopexample.service.*.set*(..))")
    public void settersInServicePackage() {}

    @Pointcut("anyMethodInServicePackage() && !(gettersInServicePackage() || settersInServicePackage())")
    public void anyMethodInServicePackageWithoutGettersAndSetters() {}
}
