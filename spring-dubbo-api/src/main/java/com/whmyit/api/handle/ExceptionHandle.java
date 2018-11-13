package com.whmyit.api.handle;

import com.whmyit.api.Enum.ResultEnum;
import com.whmyit.api.common.GlobalResult;
import com.whmyit.api.exception.BaseException;
import com.whmyit.api.util.GlobalResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: whmyit@163.com
 * @Description: 统一异常处理
 * @Date: Created in 15:26  2018/10/29
 */
@ControllerAdvice
public class ExceptionHandle {

    private final Logger LOGGER= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public GlobalResult<Object> exceptionHandle(Exception e) {
        if (e instanceof BaseException) {
            BaseException mye = (BaseException) e;
            return GlobalResultUtil.error(mye.getCode(), mye.getMessage());
        } else {
            LOGGER.error(ResultEnum.LOG_ERROR.getMsg(),e);
            return GlobalResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMsg());
        }
    }


}
