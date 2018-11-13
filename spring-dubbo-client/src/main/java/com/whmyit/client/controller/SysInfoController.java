package com.whmyit.client.controller;

import com.whmyit.api.util.JavaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: whmyit@163.com
 * @Description: 系统参数相关数据
 * @Date: Created in 11:27  2018/10/26
 */
@RestController
public class SysInfoController {


    @GetMapping("/sysInfo")
    private Object SysInfo() {
        Integer a=0;
        //System.out.println(5/a);
        //if(a==0){
        //    throw new MyException(ResultEnum.UNKONW_ERROR);
        //}
        return JavaService.getSystenProper();
    }

}
