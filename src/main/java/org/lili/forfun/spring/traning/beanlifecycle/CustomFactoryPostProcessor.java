package org.lili.forfun.spring.traning.beanlifecycle;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CustomFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
		BeanDefinition bd = bf.getBeanDefinition("car");
		bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
		log.info("调用MyBeanFactoryPostProcessor.postProcessBeanFactory()！");
	}

}
