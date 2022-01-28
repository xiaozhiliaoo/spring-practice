package org.lili.forfun.spring.training.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lili
 * @date 2019/12/23 1:39
 * @description
 */
@Service("userService")
@Transactional
public class UserService implements UserServiceInterface {
    private void method1() {
        System.out.println("method1");
    }

    public final void method2() {
        System.out.println("method2");
    }

    public static void method3() {
        System.out.println("method3");
    }

    @Override
    public void method4() {
        System.out.println("method4");
    }

    @Override
    public final void method5() {
        System.out.println("in method5");
    }

    protected void method6() {
        System.out.println("in method6");
    }

    public static void main(String[] args) {

    }


}
