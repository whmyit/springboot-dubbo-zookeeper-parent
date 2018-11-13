package com.whmyit.api.exception;

/**
 * @Author: whmyit@163.com
 * @Description: 自定义异常父类
 * @Date: Created in 15:22  2018/10/29
 */
public class BaseException extends RuntimeException {

    private Integer code;

    BaseException(String msg){
        super(msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
