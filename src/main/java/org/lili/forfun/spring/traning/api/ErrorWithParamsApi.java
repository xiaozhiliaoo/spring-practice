package org.lili.forfun.spring.traning.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author lili
 * @date 2020/3/3 14:41
 * @description
 */
@Component
@RestController
@RequestMapping("/")
@Log4j2
public class ErrorWithParamsApi extends BaseApi {

    @GetMapping("/errorGet")
    public String errorGet(@PathVariable("value") String value) {
        try {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            errorWithParams(e);
        }
        return null;
    }

    @PostMapping("/errorPost")
    public String errorPost(@RequestBody Map<String, Object> params) {
        try {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            errorWithParams(e);
        }
        return null;
    }


}
