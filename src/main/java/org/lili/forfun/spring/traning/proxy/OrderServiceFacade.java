package org.lili.forfun.spring.traning.proxy;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class OrderServiceFacade {
    public void invoke() {
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
