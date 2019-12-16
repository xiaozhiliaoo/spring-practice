package org.lili.forfun.spring.traning.config.aspectconfig;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class CommonAspect {

    @Pointcut("execution(* org.lili.forfun.spring.traning.service.HelloService.*(..))")
    public void serviceMethod() {
    }

    @Before("serviceMethod()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        log.info("doBefore name:{}", joinPoint.getSignature().getName());
    }

    @After("serviceMethod()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        log.info("doAfter name:{}", joinPoint.getSignature().getName());
    }


    @Pointcut("execution(* org.lili.forfun.spring.traning.service.PersonService.*(..))")
    public void serviceMethod2() {
    }

    @Before("serviceMethod2()")
    public void doBefore2(JoinPoint joinPoint) throws Throwable {
        log.info("doBefore2 name:{}", joinPoint.getSignature().getName());
    }

    @After("serviceMethod2()")
    public void doAfter2(JoinPoint joinPoint) throws Throwable {
        log.info("doAfter2 name:{}", joinPoint.getSignature().getName());
    }
}
