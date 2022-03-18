package org.lili.forfun.spring.training.circular.dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Provider;

/**
 * @author lili
 * @date 2022/3/18 21:54
 */
@Component
public class B2 {

    private Provider<A2> a2;

    @Autowired
    public B2(Provider<A2> a2) {
        this.a2 = a2;
    }

    public String sayB2() {
        return "I am B2";
    }
}
