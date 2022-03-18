package org.lili.forfun.spring.training.circular.dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lili
 * @date 2022/3/18 21:50
 */
@Component
public class A1 {

    private B1 b1;

    @Autowired
    public A1(B1 b1) {
        this.b1 = b1;
    }
}
