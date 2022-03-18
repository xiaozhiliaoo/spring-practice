package org.lili.forfun.spring.training.circular.dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Provider;

/**
 * @author lili
 *
 * @date 2022/3/18 21:54
 */
@Component
public class A2 {

    private Provider<B2> b2;

    @Autowired
    public A2(Provider<B2> b2) {
        this.b2 = b2;
    }

    public B2 getB2() {
        return b2.get();
    }

}
