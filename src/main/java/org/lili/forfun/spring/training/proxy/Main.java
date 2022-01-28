package org.lili.forfun.spring.training.proxy;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        log.info("--------------orderService--------------");
        OrderService orderService = new OrderServiceImpl();
        OrderProxy proxy = new OrderProxy(orderService);
        OrderService service = (OrderService) proxy.getProxy();
        service.test1();
        service.test2();
        log.info("--------------orderService2--------------");
        OrderService orderService2 = new OrderService2Impl();
        OrderProxy proxy2 = new OrderProxy(orderService2);
        OrderService service2 = (OrderService) proxy2.getProxy();
        service2.test1();
    }
}
