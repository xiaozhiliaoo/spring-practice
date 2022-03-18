package org.lili.forfun.spring.training.circular.dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author lili
 * @date 2022/3/18 21:50
 */
@Component
public class B1 {
    private A1 a1;

    @Autowired
    @Lazy
    public B1(A1 a1) {
        this.a1 = a1;
    }
}
