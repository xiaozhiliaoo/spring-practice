package org.lili.forfun.spring.training.util;

import org.springframework.stereotype.Component;

/**
 * @author lili
 * @date 2019/12/12 2:37
 * @description
 */
@Component("BeanChildB")
public class BeanChildB implements BeanParent {
    @Override
    public void say() {
        System.out.println("BeanChildB");
    }

    public void childB() {
        System.out.println("I am childB");
    }
}
