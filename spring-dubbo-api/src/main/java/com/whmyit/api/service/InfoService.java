package com.whmyit.api.service;



import com.whmyit.api.entity.SysInfo;

import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 16:45  2018/3/29
 */
public interface InfoService {
    List<SysInfo> getAll();

    String SayHello(String string);
}
