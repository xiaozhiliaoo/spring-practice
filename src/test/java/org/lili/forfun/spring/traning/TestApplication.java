package org.lili.forfun.spring.training;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    basePackages = "org.lili.forfun.spring.training")
@PropertySources({@PropertySource("classpath:spring-training-base.properties"),
        @PropertySource("classpath:spring-training-base-common.properties")})
public class TestApplication {

}