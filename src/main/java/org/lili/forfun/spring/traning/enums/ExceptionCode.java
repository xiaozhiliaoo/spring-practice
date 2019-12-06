package org.lili.forfun.spring.traning.enums;

public enum ExceptionCode {
    /**
     * 成功
     */
    SUCCESS(0, "OK"),
    /**
     * 请先登录
     */
    NOT_LOGIN(10001, "请先登录"),
    /**
     * 内部错误
     */
    INTERNAL_ERROR(10002, "内部错误"),
    /**
     * 输入参数为空
     */
    INPUTERROR(10003, "输入参数为空");

    private int code;
    private String msg;

    ExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }
}