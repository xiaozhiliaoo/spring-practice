package org.lili.forfun.spring.training.proxy;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class OrderServiceImpl implements OrderService {
    @Override
    public void test1() {
        log.info("invoke test1 ...");
    }

    @Override
    public void test2() {
        log.info("invoke test2 ...");
    }
}
