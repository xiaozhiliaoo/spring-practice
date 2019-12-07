package org.lili.forfun.spring.traning.api;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.spring.traning.db.domain.Person;
import org.lili.forfun.spring.traning.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@Log4j2
@RestController
@RequestMapping("/helloApi")
public class HelloApi extends BaseApi{

    @Autowired
    private HelloService helloService;

    @GetMapping("/first")
    public RequestResult<Void> first() {
        try {
            helloService.first();
        } catch (Exception e) {
            log.error("hi error:", e);
        }
        return succ();
    }

    @GetMapping("/second")
    public RequestResult<Void> second() {
        try {
            helloService.second();
        } catch (Exception e) {
            log.error("hi error:", e);
        }
        return succ();
    }

}
