package org.lili.forfun.spring.traning.config.aspectconfig;


import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ControllerExceptionAdvice {

    @Autowired
    private HttpServletRequest request;

    @ResponseBody
    @ExceptionHandler(value = ClientAbortException.class)
    public void catchIt(ClientAbortException exception) {
        String url = request.getRequestURI();
        log.error("url {}", url, exception);
    }
}