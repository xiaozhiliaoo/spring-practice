package org.lili.forfun.spring.traning.beanlifecycle;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.stereotype.Component;

/**
 * @author lili
 * @date 2019/12/16 23:13
 * @description
 */
@Component
@Log4j2
public class CustomBeanClassLoaderAware implements BeanClassLoaderAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
       log.info("CustomBeanClassLoaderAware classLoader is:{}", JSON.toJSONString(classLoader));
    }
}
