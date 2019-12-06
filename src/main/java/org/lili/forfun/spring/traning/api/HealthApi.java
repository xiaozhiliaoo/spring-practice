package org.lili.forfun.spring.traning.api;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Component
@RestController
@RequestMapping("/")
@Log4j2
public class HealthApi extends BaseApi {

    @GetMapping("/ok")
    public String ok(String v) {
        log.debug("{}", v);
        return v;
    }

    @GetMapping("/health")
    public String health() {
        log.debug("{}", System.currentTimeMillis());
        return "OK";
    }

}