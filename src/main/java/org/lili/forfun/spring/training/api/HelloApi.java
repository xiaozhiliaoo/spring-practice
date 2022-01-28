package org.lili.forfun.spring.training.api;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.spring.training.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@Log4j2
@RestController
@RequestMapping("/helloApi")
public class HelloApi extends BaseApi {

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


    @GetMapping("/third")
    public RequestResult<Void> third() {
        try {
            System.out.println("----1----");
            throw new RuntimeException("runtimeException");
        } catch (Exception e) {
            log.error("hi error:[{}] {}", "hello", "hello2", e);
        }
        return succ();
    }

    @PostMapping("/four")
    public RequestResult<Void> four(@RequestBody Map<String, String> paramsMap) {
        try {
            System.out.println("----1----");
            throw new RuntimeException("runtimeException");
        } catch (Exception e) {
            log.error("hi error:[{}] {}", "hello", "hello2", e);
        }
        return succ();
    }

}
