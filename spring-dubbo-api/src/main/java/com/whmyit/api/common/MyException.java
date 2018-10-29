package com.whmyit.api.common;

/**
 * @Author: whmyit@163.com
 * @Description: 自定义异常
 * @Date: Created in 15:22  2018/10/29
 */
public class MyException extends RuntimeException {

    private String code;

    public MyException (String code ,String msg){
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
