package org.lili.forfun.spring.training.circular.dependencies;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.spring.training.api.BaseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lili
 * @date 2022/3/18 22:03
 */
@Component
@Log4j2
@RestController
@RequestMapping("/cd")
public class CircularDependenciesApi extends BaseApi {

    @Autowired
    private A2 a2;

    @GetMapping("/sayB2")
    public String sayB2() {
        return a2.getB2().sayB2();
    }


}
