package org.lili.forfun.spring.reading.context;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

/**
 * @author lili
 * @date 2020/11/22 17:24
 * @notes
 */
public class DefaultListableBeanFactoryTest {

    public static void main(String[] args) {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //BeanPostProcessor生效
        factory.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor());

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new FileSystemResource("beans.xml"));

        // bring in some property values from a Properties file
        // BeanFactoryPostProcessor生效
        PropertySourcesPlaceholderConfigurer cfg = new PropertySourcesPlaceholderConfigurer();
        cfg.setLocation(new FileSystemResource("jdbc.properties"));

        // now actually do the replacement
        cfg.postProcessBeanFactory(factory);
    }
}
