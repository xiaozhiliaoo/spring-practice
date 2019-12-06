package org.lili.forfun.spring.traning;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.lili.forfun"})
@PropertySources({@PropertySource("classpath:spring-traning-base.properties"),
        @PropertySource("classpath:spring-traning-base-common.properties")})
@Log4j2
public class SpringTraningBaseApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringTraningBaseApplication.class, args);
        } catch (Throwable e) {
            log.error("", e);
        }
    }
}
