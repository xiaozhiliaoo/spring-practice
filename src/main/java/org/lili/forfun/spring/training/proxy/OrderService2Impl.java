package org.lili.forfun.spring.training.proxy;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class OrderService2Impl implements OrderService {
    @Override
    public void test1() {
        log.info("invoke test1 ...");
        //此时test2不会走代理,相当于被代理对象调用test2
        test2();
        //此时test2重新获取代理对象，就会走代理
        log.info("reget proxy orderProxy object ...");
        OrderProxy orderProxy = new OrderProxy(new OrderService2Impl());
        OrderService proxy = (OrderService) orderProxy.getProxy();
        proxy.test2();
    }

    @Override
    public void test2() {
        log.info("invoke test2 ...");
    }
}
