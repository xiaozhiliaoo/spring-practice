package org.lili.forfun.spring.traning.config.aspectconfig;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author lili
 * @date 2019/12/16 19:03
 * @description
 */
@Aspect
@Component
@Log4j2
public class WebLogAspect {

    private static ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(requestMapping) && " + "execution(public * org.lili.forfun.spring.traning.api..*.*(..))")
    public void webLog(RequestMapping requestMapping) {
    }

    @Before("webLog(requestMapping)")
    public void doBefore(JoinPoint joinPoint, RequestMapping requestMapping) throws Throwable {
        startTime.set(System.currentTimeMillis());
        HttpServletRequest request = getRequest();
        request.setAttribute("beginTime", System.currentTimeMillis());
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        String params = Arrays.toString(joinPoint.getArgs());
        log.info("URL:{},HTTP_METHOD:{},IP:{},CLASS_METHOD:{},ARGS:{}",
                request.getRequestURL().toString(),
                request.getMethod(),
                request.getRemoteAddr(), classMethod, params);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog(requestMapping)")
    public void doAfterReturning(Object ret, RequestMapping requestMapping) throws Throwable {
        HttpServletRequest request = getRequest();
        long costTime = System.currentTimeMillis() - startTime.get();
        log.info("requestURI : " + request.getRequestURI() + " | costTime : " + costTime);
        startTime.remove();
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
    }
}
