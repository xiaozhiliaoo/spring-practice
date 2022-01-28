package org.lili.forfun.spring.training.config.aspectconfig;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.util.Objects;

/**
 * @author lili
 * @date 2019/12/16 19:09
 * @description
 */
@Component
@Aspect
@Log4j2
public class LogAspect {

    @Pointcut(" execution(* org.lili.forfun.spring.training.api.*.*.*(..))")
    public void pointerCutMethod() {
    }

    @Around(value = "pointerCutMethod()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Long beginTime = System.currentTimeMillis();
        Object[] params = joinPoint.getArgs();
        Annotation[][] annos = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterAnnotations();
        StringBuilder param = new StringBuilder();
        for (int i = 0; i < annos.length; i++) {
            for (int j = 0; j < annos[i].length; j++) {
                if (annos[i][j].annotationType() == RequestParam.class) {
                    param.append(Objects.toString(params[i]));
                }
            }
        }

        String methodName = joinPoint.getSignature().getName();
        if (requestAttributes != null) {
            ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
            HttpServletRequest request = sra.getRequest();
            String ip = request.getRemoteHost();
            String userId = (String) request.getAttribute("uid");
            String requestURI = sra.getRequest().getRequestURI();
            log.info("ip:{},userId:{},url:{},methodName:{},params:{}", ip, userId,
                    requestURI, methodName, JSON.toJSONString(param));
        }
        try {
            Object object = joinPoint.proceed();
            log.info("methodName:{}, time:{} ms, result:{}", methodName,
                    (System.currentTimeMillis() - beginTime), JSON.toJSONString(object));
            return object;
        } catch (Throwable e) {
            log.error("method error:methodName:{}", methodName, e);
            throw e;
        }
    }
}

