package org.lili.forfun.spring.reading.context;

import org.lili.forfun.spring.reading.service.PersonService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author lili
 * @date 2020/11/22 12:37
 * @notes
 */
public class GenericApplicationContextTest {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        boolean containsMyProperty = environment.containsProperty("my-property");
        System.out.println(containsMyProperty);
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("services.xml");
        context.refresh(); //org.springframework.context.support.GenericApplicationContext@7530d0a has not been refreshed yet
        PersonService personService = context.getBean(PersonService.class);
        System.out.println(personService.sayName());


//        GenericApplicationContext context2 = new GenericApplicationContext();
//        new GroovyBeanDefinitionReader(context2).loadBeanDefinitions("services.groovy");
//        context2.refresh();

    }
}
