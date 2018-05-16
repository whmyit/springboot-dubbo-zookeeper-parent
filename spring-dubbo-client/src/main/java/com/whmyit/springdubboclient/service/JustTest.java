package com.whmyit.springdubboclient.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.whmyit.springdubboservice.service.InfoService;
import org.springframework.stereotype.Component;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 12:03  2018/5/16
 */

@Component
public class JustTest {

    //注入服务提供方暴露的接口，通过@Reference注解，dubbo会在扫描的时候自动代理接口，然后通过rpc调用远程服务。
    //如果用xml配置方式，需要将@Reference换成@Autowired。
    @Reference
    InfoService infoService;


    public String sayHello(String str){
        return infoService.SayHello(str);
    }




}
