package com.whmyit.api.Enum;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 17:31  2018/10/30
 */
public enum BaseEnum {
    UNKONW_ERROR(-1,"位置错误"),
    SUCCESS(0,"成功"),
    ;
    private Integer code;
    private String  msg;

    BaseEnum(Integer code,String msg){
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
