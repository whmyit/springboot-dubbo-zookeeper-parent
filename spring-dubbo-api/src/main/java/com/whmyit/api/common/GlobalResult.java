package com.whmyit.api.common;

/**
 * @Author: whmyit@163.com
 * @Description: controller 统一返回结果
 * @Date: Created in 11:23  2018/10/26
 */
public class GlobalResult<T> {

    private String status;
    private String msg;
    private T data;


    public GlobalResult() {
    }

    public GlobalResult(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public GlobalResult(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return status;
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
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
