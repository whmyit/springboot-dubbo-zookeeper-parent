package com.whmyit.api.exception;

import com.whmyit.api.Enum.ResultEnum;

/**
 * @Author: whmyit@163.com
 * @Description: 自定义异常
 * @Date: Created in 15:22  2018/10/29
 */
public class MyException extends BaseException {

    private Integer code;

    public MyException (ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
