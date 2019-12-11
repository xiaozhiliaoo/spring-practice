package org.lili.forfun.spring.traning.util;

import org.springframework.stereotype.Component;

/**
 * @author lili
 * @date 2019/12/12 2:41
 * @description
 */
@Component
public class BeanManager {
    public BeanParent getBean(String name) {
        return (BeanParent) SpringUtil.getBean(name);
    }
}
