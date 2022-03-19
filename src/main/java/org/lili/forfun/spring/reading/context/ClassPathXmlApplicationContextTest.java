package org.lili.forfun.spring.reading.context;

import org.lili.forfun.spring.reading.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lili
 * @date 2020/11/22 12:07
 * @notes
 */
public class ClassPathXmlApplicationContextTest {

    public static void main(String[] args) {
        try {
            //不存在的文件看报错
            ApplicationContext context = new ClassPathXmlApplicationContext("mappers.xml", "daos.xml");
            System.out.println(context);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ApplicationContext context2 = new ClassPathXmlApplicationContext("services.xml");
            PersonService personService = context2.getBean(PersonService.class);
            System.out.println(context2);
            System.out.println(personService.sayName());
            System.out.println(context2.getParentBeanFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
