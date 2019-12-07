package org.lili.forfun.spring.traning.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class HelloService {

    public void first() {
        log.info("first ....");
        second(1);
        ((HelloService) AopContext.currentProxy()).second(2);
        third(1);
        ((HelloService) AopContext.currentProxy()).third(2);
    }

    public void second() {
        log.info("second ...");
    }

    private void second(int i) {
        log.info("second ...{}", i);
    }

    public void third(int i) {
        log.info("third ...{}", i);
    }
}
