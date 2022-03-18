package org.lili.forfun.spring.training.api;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.lili.forfun.spring.training.enums.ExceptionCode;
import org.lili.forfun.spring.training.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

@Log4j2
public abstract class BaseApi {

    protected static final String APPLICATION_JSON = "application/json; charset=utf-8";

    <T> RequestResult<T> process(T t) {
        RequestResult<T> rr = new RequestResult<>();
        rr.setData(t);
        String json = JSON.toJSONString(rr);
        if (json.length() > 200) {
            json = json.substring(0, 200) + " ...";
        }
        log.info("result json: {}", json);
        return rr;
    }

    /**
     * 生成失败响应
     *
     * @param msg 失败原因
     * @return
     */
    <T> RequestResult<T> error(String msg) {
        log.error("RequestResult error msg: {}", msg);
        RequestResult<T> rr = new RequestResult<>(ExceptionCode.INTERNAL_ERROR.getCode(), msg);
        log.info("result json: {}", JSON.toJSONString(rr));
        return rr;
    }

    public <T> RequestResult<T> error(Exception e) {
        log.error("RequestResult error msg: {}", e.getMessage());
        return new RequestResult<>(ExceptionCode.INTERNAL_ERROR.getCode(), e.getMessage());
    }

    public <T> RequestResult<T> error(BusinessException e) {
        log.error("RequestResult error msg: {}", e.getMessage());
        return new RequestResult<>(ExceptionCode.INTERNAL_ERROR.getCode(), e.getMessage());
    }

    /**
     * 生成成功响应
     *
     * @return
     */
    <T> RequestResult<T> succ() {
        RequestResult<T> rr = new RequestResult<>();
        log.info("result json: {}", JSON.toJSONString(rr));
        return rr;
    }

    @Autowired
    private HttpServletRequest request;

    protected void errorWithParams(Exception e) {
        String method = request.getMethod();
        String params = "";
        if ("GET".equalsIgnoreCase(method)) {
            params = JSON.toJSONString(request.getParameterMap());
        } else if ("POST".equalsIgnoreCase(method)) {
            try {
                params = JSON.toJSONString(request.getParameterMap());
            } catch (Exception convertException) {
                log.error("", convertException);
            }
        }
        String requestURI = request.getRequestURI();
        log.error("uri is:{}, params:{}, error:{}", requestURI, params, e);
    }
}
