package org.lili.forfun.spring.training.beanlifecycle;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.Lifecycle;
import org.springframework.context.LifecycleProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * https://docs.spring.io/spring/docs/5.2.1.RELEASE/spring-framework-reference/core.html#beans-factory-nature
 * https://docs.spring.io/spring/docs/5.2.1.RELEASE/spring-framework-reference/core.html#beans-factory-extension
 */
@Log4j2
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean, LifecycleProcessor {

	private String brand;
	private String color;
	private int maxSpeed;
	private String name;
	private BeanFactory beanFactory;
	private String beanName;

	@PostConstruct
	public void postInit() {
		log.info("construct by @PostConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		log.info("preDestroy by @PreDestroy");
	}

	public Car() {
		System.out.println("调用Car()构造函数。");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("调用setBrand()设置属性。");
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "brand:" + brand + "/color:" + color + "/maxSpeed:"+ maxSpeed;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public void introduce(){
		System.out.println("introduce:"+this.toString());
	}
	

	// BeanFactoryAware接口方法
    @Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用BeanFactoryAware.setBeanFactory()。");
		this.beanFactory = beanFactory;
	}

	// BeanNameAware接口方法
    @Override
	public void setBeanName(String beanName) {
		System.out.println("调用BeanNameAware.setBeanName()。");
		this.beanName = beanName;
	}

	// InitializingBean接口方法
    @Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用InitializingBean.afterPropertiesSet()。");
	}

	// DisposableBean接口方法
    @Override
	public void destroy() throws Exception {
		System.out.println("调用DisposableBean.destory()。");
	}

	public void myInit() {		
		System.out.println("调用myInit()，将maxSpeed设置为240。");
		this.maxSpeed = 240;
	}

	public void myDestory() {
		System.out.println("调用myDestroy()。");
	}

	@Override
	public void start() {
		log.info("car is start...");
	}

	@Override
	public void stop() {
		log.info("car is stop...");
	}

	@Override
	public boolean isRunning() {
		return false;
	}

	@Override
	public void onRefresh() {
		log.info("car is onRefresh...");

	}

	@Override
	public void onClose() {
		log.info("car is onClose...");
	}
}
