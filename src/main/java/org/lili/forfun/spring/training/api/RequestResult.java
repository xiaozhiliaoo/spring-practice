package org.lili.forfun.spring.training.api;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestResult<T> {

    private T data;
    private int code;
    private String message;

    public RequestResult(int code, String message) {
        this.code = code;
        this.message=message;
    }
}
