package org.lili.forfun.spring.training.proxy;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Log4j2
public class OrderProxy implements InvocationHandler {

    public static final String METHOD_PREFIX = "test";

    private Object target;

    public OrderProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if (name.startsWith(METHOD_PREFIX)) {
            log.info("-----invoke {} proxy-------", name);
        }
        return method.invoke(target, args);
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
