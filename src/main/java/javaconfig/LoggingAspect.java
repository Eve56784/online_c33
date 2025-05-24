package javaconfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* javaconfig.MyServiceJava.*(..))")
    public void beforeExecution() {
        System.out.println("Log: Before execution");
    }

    @Around("execution(* javaconfig.MyServiceJava.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("(around) Log: Before execution");
        Object result = joinPoint.proceed();
        System.out.println("(around) Log: After execution");
        return result;
    }

    @After("execution(* javaconfig.MyServiceJava.*(..))")
    public void afterExecution() {
        System.out.println("Log: After execution");
    }
}
