package org.lili.forfun.spring.traning.api;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.lili.forfun.spring.traning.enums.ExceptionCode;

@Slf4j
abstract class BaseApi {

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
        log.warn("RequestResult error msg: {}", msg);
        RequestResult<T> rr = new RequestResult<>(ExceptionCode.INTERNAL_ERROR.getCode(), msg);
        log.info("result json: {}", JSON.toJSONString(rr));
        return rr;
    }

    public <T> RequestResult<T> error(Exception e) {
        log.warn("RequestResult error msg: {}", e.getMessage());
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
}
