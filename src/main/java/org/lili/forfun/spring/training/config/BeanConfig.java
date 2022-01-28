package org.lili.forfun.spring.training.config;

import org.lili.forfun.spring.training.beanlifecycle.CustomServletConfigAware;
import org.lili.forfun.spring.training.beanlifecycle.CustomServletContextAware;
import org.lili.forfun.spring.training.beanlifecycle.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lili
 * @date 2019/12/16 22:38
 * @description
 */
@Configuration
public class BeanConfig {
    //等价于xml里面配置
    @Bean(name = "car", initMethod = "myInit", destroyMethod = "myDestory")
    public Car getCar() {
        Car car = new Car();
        car.setMaxSpeed(9999);
        car.setBrand("红旗");
        return car;
    }

    @Bean
    public CustomServletContextAware getCustomServletContextAware() {
        return new CustomServletContextAware();
    }

    @Bean
    public CustomServletConfigAware getCustomServletConfigAware() {
        return new CustomServletConfigAware();
    }
}
