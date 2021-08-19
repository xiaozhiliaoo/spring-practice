package org.lili.forfun.spring.traning.config;

import lombok.Data;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Data
public class TomcatConfig {

    @Value("${port:9888}")
    private int port;

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers(new ExchangeTomcatConnectionCustomizer());
        return tomcat;
    }

    /**
     * springboot2.0.1以上
     */
    private class ExchangeTomcatConnectionCustomizer implements TomcatConnectorCustomizer {

        private ExchangeTomcatConnectionCustomizer() {
        }

        @Override
        public void customize(Connector connector) {
            // tomcat connector 配置  http://tomcat.apache.org/tomcat-9.0-doc/config/http.html#Introduction
            // 如果这里配置了port，conf.properties port将不生效
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            protocol.setPort(getPort());
            protocol.setConnectionTimeout(30000);
            protocol.setMaxThreads(2000);
            protocol.setMaxConnections(2000);
        }
    }


}
