package com.whmyit.api.handle;

import com.whmyit.api.common.GlobalResult;
import com.whmyit.api.util.GlobalResultUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: whmyit@163.com
 * @Description: controller 统一结果返回
 * @Date: Created in 10:10  2018/10/30
 */
@ControllerAdvice
public class ResultHandle implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(object instanceof GlobalResult){
            GlobalResult<Object> result=(GlobalResult<Object>)object;
            if(!(result.getCode()==0));
            return result;
        }

        return GlobalResultUtil.success(object);
    }
}
