package com.whmyit.api.util;

import com.whmyit.api.Enum.ResultEnum;
import com.whmyit.api.common.GlobalResult;

/**
 * @Author: whmyit@163.com
 * @Description: GlobalResult 工具类
 * @Date: Created in 16:30  2018/10/30
 */
public class GlobalResultUtil {

    public static GlobalResult<Object> success(Object obj){
        GlobalResult<Object> reuslt = new GlobalResult<Object>();
        reuslt.setCode(ResultEnum.SUCCESS.getCode());
        reuslt.setMsg(ResultEnum.SUCCESS.getMsg());
        reuslt.setData(obj);
        return reuslt;
    }

    public static GlobalResult success(){
        return success(null);
    }

    public static GlobalResult error(Integer code,String msg){
        return   new GlobalResult(code,msg);
    }

}
