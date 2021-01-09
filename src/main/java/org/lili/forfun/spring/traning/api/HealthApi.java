package org.lili.forfun.spring.traning.api;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;



@Component
@RestController
@RequestMapping("/")
@Log4j2
public class HealthApi extends BaseApi {

    @GetMapping("/ok/{value}")
    public String ok(@PathVariable("value") String value) {
        log.debug("{}", value);
        return value;
    }

    @GetMapping("/health")
    public String health() {
        log.debug("{}", System.currentTimeMillis());
        log.info("I am health");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            builder.append("alibababab");
        }
        return builder.toString();
    }

    @GetMapping("/health2")
    public String health2() {
        log.debug("{}", System.currentTimeMillis());
        log.info("I am health");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            builder.append("alibaba");
        }
        return builder.toString();
    }

}