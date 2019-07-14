package com.school.util;


public class ApiCode extends AbstractApiCode {
    public static final int _C_OK = 200;
    public static final ApiCode OK = new ApiCode((String)null, _C_OK);
    public static final int _C_NOT_FOUND = 404;
    public static final ApiCode NOT_FOUND = new ApiCode("请求资源不存在", _C_NOT_FOUND);
    public static final int _C_UNKNOWN_ERROR = 500;
    public static final ApiCode UNKNOWN_ERROR = new ApiCode("服务端内部错误", _C_UNKNOWN_ERROR);
    public static final int _C_PARAMETER_ERROR = 400;
    public static final ApiCode PARAMETER_ERROR = new ApiCode("参数错误", _C_PARAMETER_ERROR);


    protected ApiCode(String message, int code) {
        super(code, message);
    }
}

