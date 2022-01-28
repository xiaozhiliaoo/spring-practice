package org.lili.forfun.spring.training.api;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.spring.training.proxy.OrderServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@Log4j2
@RestController
@RequestMapping("/proxyApi")
public class JavaProxyApi extends BaseApi {

    @Autowired
    private OrderServiceFacade facade;

    @GetMapping("/proxy")
    public RequestResult<Void> parent2() {
        facade.invoke();
        return succ();
    }
}
