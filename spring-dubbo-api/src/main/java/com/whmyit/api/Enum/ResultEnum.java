package com.whmyit.api.Enum;

/**
 * @Author: whmyit@163.com
 * @Description: 异常返回结果枚举
 * @Date: Created in 17:22  2018/10/30
 */
public enum ResultEnum  {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    LOG_ERROR(-1, "【系统异常】{ }"),
    ;
    private Integer code;
    private String  msg;

    ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
