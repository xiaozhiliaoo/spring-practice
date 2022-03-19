package org.lili.forfun.spring.reading.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lili
 * @date 2020/11/22 16:23
 * @notes
 */
public class AnnotationConfigApplicationContextTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        MyService myService = ctx.getBean(MyService.class);
        myService.doStuff();


        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService2 = ctx2.getBean(MyService.class);
        myService2.doStuff();


        AnnotationConfigApplicationContext ctx3 = new AnnotationConfigApplicationContext();
        ctx3.scan("org.lili");
        ctx3.refresh();
        MyService myService3 = ctx.getBean(MyService.class);
        myService3.doStuff();

    }
}
