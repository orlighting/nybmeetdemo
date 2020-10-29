package com.example.nybproject.meet.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhaoDesong
 * @date 2020/10/29 17:08
 */
@Data
public final class HttpResult<T> implements Serializable {

    private static final int SUCCESS_CODE = 200;
    private static final String SUCCESS_MSG = "success";

    private final int code;
    private final String msg;
    private final T data;

    private HttpResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <Result> HttpResult<Result> of() {
        return new HttpResult<>(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static <Result> HttpResult<Result> of(Result data) {
        return new HttpResult<>(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <Result> HttpResult<Result> of(int code) {
        return new HttpResult<>(code, null, null);
    }

    public static <Result> HttpResult<Result> of(int code, String msg) {
        return new HttpResult<>(code, msg, null);
    }

    public static <Result> HttpResult<Result> of(int code, String msg, Result data) {
        return new HttpResult<>(code, msg, data);
    }
}
