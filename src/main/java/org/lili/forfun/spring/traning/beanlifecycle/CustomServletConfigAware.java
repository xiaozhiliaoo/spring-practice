package org.lili.forfun.spring.traning.beanlifecycle;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletConfigAware;

import javax.servlet.ServletConfig;

/**
 * @author lili
 * @date 2019/12/16 23:07
 * @description
 */
@Log4j2
public class CustomServletConfigAware implements ServletConfigAware {
    @Override
    public void setServletConfig(ServletConfig servletConfig) {
       log.info("servletConfig is:{}", JSON.toJSONString(servletConfig));
    }
}
