package org.lili.forfun.spring.training.config;

import org.lili.forfun.spring.training.interceptor.CommonInterceptor;
import org.lili.forfun.spring.training.interceptor.CommonInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author lili
 * @date 2019/12/16 19:27
 * @description
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor());
        registry.addInterceptor(new CommonInterceptor2());
    }
}
