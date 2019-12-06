package org.lili.forfun.spring.traning.config;

import lombok.Data;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "tom")
@Data
public class TomcatConfig {
    private int maxConnections;
    private int maxThreads;
    private int soTimeout;

    @Bean
    public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
        tomcatFactory.addConnectorCustomizers((TomcatConnectorCustomizer)connector -> {
            Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
            protocol.setMaxConnections(getMaxConnections());
            protocol.setMaxThreads(getMaxThreads());
            protocol.setConnectionTimeout(getSoTimeout());
            protocol.setMaxSwallowSize(-1);
        });
        return tomcatFactory;
    }
}