package org.lili.forfun.spring.traning.beanlifecycle;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean:{} created:{} ", beanName, bean.toString());
        if (beanName.equals("car")) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() >= 200) {
                System.out.println("调用MyBeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200。");
                car.setMaxSpeed(200);
            }
        }
        return bean;

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean:{} created:{} ", beanName, bean.toString());
        if (beanName.equals("car")) {
            Car car = (Car) bean;
            if (car.getColor() == null) {
                System.out.println("调用MyBeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色。");
                car.setColor("黑色");
            }
        }
        return bean;
    }
}
