package org.lili.forfun.spring.reading.context;

import org.lili.forfun.spring.reading.service.PersonService;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author lili
 * @date 2020/11/22 12:19
 * @notes
 */
public class XmlBeanFactoryTest {

    public static void main(String[] args) {
        try {
            XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("services.xml"));
            PersonService personService = beanFactory.getBean(PersonService.class);
            System.out.println(beanFactory);
            System.out.println(personService.sayName());

//            beanFactory.registerBeanDefinition();
//            beanFactory.registerSingleton();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
