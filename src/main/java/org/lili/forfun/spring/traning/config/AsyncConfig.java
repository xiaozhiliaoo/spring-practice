package org.lili.forfun.spring.traning.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {

    public static final int CORE_POOL_SIZE = 10;
    public static final int MAX_POOL_SIZE = 10;
    public static final int QUEUE_CAPACITY = 1000;

    @Bean
    @Qualifier("AsyncTaskUtils")
    public Executor getExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        taskExecutor.setThreadNamePrefix("AsyncTask-");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
