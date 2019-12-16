package org.lili.forfun.spring.traning.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lili
 * @date 2019/12/16 19:37
 * @description
 */
@Component
@Log4j2
public class OpsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("OpsFilter doFilter");
        //不加这句请求会阻塞到这里
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
