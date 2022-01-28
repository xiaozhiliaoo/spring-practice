package org.lili.forfun.spring.training;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.spring.training.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author lili
 * @date 2020/1/10 15:43
 * @description
 */
@Component
@Log4j2
public class SpringTrainingBaseLifeCycle2 implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private HelloService service;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("ContextRefreshedEvent to invoke helloservice");
        service.first();
    }
}
