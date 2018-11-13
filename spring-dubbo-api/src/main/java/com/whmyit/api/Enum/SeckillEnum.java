package com.whmyit.api.Enum;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 10:49  2018/11/12
 */
public enum SeckillEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATE_REWRITE(-3,"数据篡改");
    ;
    private Integer code;
    private String  msg;

    SeckillEnum(Integer code,String msg){
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
