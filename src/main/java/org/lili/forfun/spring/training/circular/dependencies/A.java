package org.lili.forfun.spring.training.circular.dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lili
 * @date 2022/3/18 21:50
 */
@Component
public class A {
    @Autowired
    private B b;
}
