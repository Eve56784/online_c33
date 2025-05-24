package xml.config;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

    public void beforeExecution() {
        System.out.println("Log: Before execution");
    }

    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("(around) Log: Before execution");
        Object result = joinPoint.proceed();
        System.out.println("(around) Log: After execution");
        return result;
    }

    public void afterExecution() {
        System.out.println("Log: After execution");
    }
}