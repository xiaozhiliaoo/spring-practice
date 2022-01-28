package org.lili.forfun.spring.training.util;

import org.springframework.stereotype.Component;

/**
 * @author lili
 * @date 2019/12/12 2:36
 * @description
 */
@Component("BeanChildA")
public class BeanChildA implements BeanParent {
    @Override
    public void say() {
        System.out.println("BeanChildA");
    }

    public void childA() {
        System.out.println("I am childA");
    }
}
