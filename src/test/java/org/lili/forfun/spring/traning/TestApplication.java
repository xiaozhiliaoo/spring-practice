package org.lili.forfun.spring.traning;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    basePackages = "org.lili.forfun.transaction.traning")
@PropertySources({@PropertySource("classpath:spring-traning-base.properties"),
        @PropertySource("classpath:spring-traning-base-common.properties")})
public class TestApplication {

}