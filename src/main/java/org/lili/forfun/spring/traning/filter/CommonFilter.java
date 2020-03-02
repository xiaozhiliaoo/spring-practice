package org.lili.forfun.spring.traning.filter;


import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author lili
 * @date 2019/12/16 19:30
 * @description
 */
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*", filterName = "CommonFilter")
@Log4j2
public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CommonFilter init ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("CommonFilter doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("CommonFilter destroy");
    }
}
