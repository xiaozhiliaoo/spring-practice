package org.lili.forfun.spring.traning.config;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
}
