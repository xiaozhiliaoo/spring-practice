package org.lili.forfun.spring.training;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan(basePackages = {"org.lili.forfun"})
@PropertySources({@PropertySource("classpath:spring-training-base.properties"),
        @PropertySource("classpath:spring-training-base-common.properties")})
@Log4j2
public class SpringTrainingBaseApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringTrainingBaseApplication.class, args);
        } catch (Throwable e) {
            log.error("", e);
        }
    }
}
