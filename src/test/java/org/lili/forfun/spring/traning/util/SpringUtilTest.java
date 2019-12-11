package org.lili.forfun.spring.traning.util;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lili.forfun.spring.traning.TestApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author lili
 * @date 2019/12/12 2:35
 * @description
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class SpringUtilTest {

    @Autowired
    private BeanManager beanManager;

    @Test
    public void getBean() {
        BeanParent beanChildA = beanManager.getBean("BeanChildA");
        beanChildA.say();
        BeanParent beanChildB = beanManager.getBean("BeanChildB");
        beanChildB.say();

        BeanChildA beanChildA2 = (BeanChildA) beanManager.getBean("BeanChildA");
        beanChildA2.say();
        beanChildA2.childA();

        BeanChildB beanChildB2 = (BeanChildB) beanManager.getBean("BeanChildB");
        beanChildB2.say();
        beanChildB2.childB();
    }
}