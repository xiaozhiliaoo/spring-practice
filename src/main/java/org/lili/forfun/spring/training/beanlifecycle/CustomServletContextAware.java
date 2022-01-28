package org.lili.forfun.spring.training.beanlifecycle;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * @author lili
 * @date 2019/12/16 22:29
 * @description
 */
@Log4j2
public class CustomServletContextAware implements ServletContextAware {
    @Override
    public void setServletContext(ServletContext servletContext) {
        //bean的定义在BeanConfig里面，如果不定义，需要加@Component注解
        log.info("CustomServletContextAware load ...servletContext is:{}", JSON.toJSONString(servletContext));
    }
}
