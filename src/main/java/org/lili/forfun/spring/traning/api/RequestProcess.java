package org.lili.forfun.spring.traning.api;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.spring.traning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lili
 * @date 2019/12/16 19:56
 * @description 查看从tomcat到springmvc请求的过程以及异常堆栈，以及拦截器，过滤器，事务，切面，
 * 重在分析web请求过程：1 启动初始化 2 请求过程
 * https://blog.csdn.net/weixin_30856965/article/details/95026239
 * 里面有三大组件：1 servlet容器 2 spring容器 3 springmvc，有两大过程：1 启动 2 处理请求
 *
 */
@Component
@Log4j2
@RestController
@RequestMapping("/requestProcess")
public class RequestProcess extends BaseApi{

    private PersonService personService;

    @Autowired
    public RequestProcess(PersonService personService) {
        this.personService = personService;
    }

    /**
     * 这个方法用来通过异常方式查看整个web请求已经拦截
     * @return
     */
    @GetMapping("/showErrorStackTraceToLearnWebRequestProcess")
    public RequestResult<Void> showErrorStackTrace() {
        try {
            personService.showErrorStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("showErrorStackTraceToLearnWebRequestProcess error:", e);
            return error(e.getMessage());
        }
        return succ();
    }
}
