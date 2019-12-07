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
        return "OK";
    }

}