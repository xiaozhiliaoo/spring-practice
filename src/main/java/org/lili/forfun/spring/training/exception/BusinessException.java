package org.lili.forfun.spring.training.exception;


public class BusinessException extends Exception {
    private static final long serialVersionUID = 6828531065550857194L;
    int code;

    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public int getCode() {
        return code;
    }
}
