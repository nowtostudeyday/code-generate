package com.zhang.generate.exception;

/**
 * @Description
 * @Author Mr.Zhang
 * @Date 2025/5/28 0:09
 * @Version 1.0
 */
public class BizException extends RuntimeException {

    private int code;  // 错误码

    private String msg;  // 错误信息

    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
