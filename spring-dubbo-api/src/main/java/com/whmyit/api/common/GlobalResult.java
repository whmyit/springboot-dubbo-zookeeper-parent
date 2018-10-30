package com.whmyit.api.common;

/**
 * @Author: whmyit@163.com
 * @Description: controller 统一返回结果
 * @Date: Created in 11:23  2018/10/26
 */
public class GlobalResult<T> {

    private Integer code;
    private String msg;
    private T data;


    public GlobalResult() {
    }

    public GlobalResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GlobalResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GlobalResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
