package com.school.util;

import java.io.Serializable;
import java.util.Map;

public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success;
    private int code;
    private String message;
    private T data;

    public ApiResult() {
        this.success = true;
    }

    public ApiResult(ApiCode apiCode) {
        this(apiCode.getCode(),apiCode.getMessage());
    }

    private ApiResult(int code, String message) {
        this.success = true;
        this.code = code;
        if(code != 200) {
            this.success = false;
        }

        this.message = message;
    }

    private ApiResult(ApiCode apiCode, T data) {
        this(apiCode.getCode(), apiCode.getMessage());
        this.data = data;
    }

    public static ApiResult ok() {
        return new ApiResult(ApiCode.OK);
    }

    public static ApiResult ok(Object value) {
        return new ApiResult(ApiCode.OK, value);
    }


    public static ApiResult ok(Map<String, Object> data) {
        return new ApiResult(ApiCode.OK, data);
    }


    public static ApiResult error(ApiCode code) {
        return new ApiResult(code);
    }

    public static ApiResult error(ApiCode code, Object value) {
        return new ApiResult(code, value);
    }

    public static ApiResult error(ApiCode code, Map<String, Object> data) {
        return new ApiResult(code, data);
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
