package com.whmyit.service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.whmyit.api.entity.SysInfo;
import com.whmyit.api.service.InfoService;
import com.whmyit.api.util.JavaService;
import com.whmyit.service.dao.SysInfoDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 11:39  2018/5/16
 */
@Service //该Service注解是dubbo的注解，不是spring的。若使用xml配置方式暴露接口，则不需要该注解。
public class InfoServiceImpl implements InfoService {


    @Autowired
    private SysInfoDao sysInfoDao;


    @Override
    public List<SysInfo> getAll() {
        return sysInfoDao.getAll();
    }

    @Override
    public String SayHello(String string) {
        JavaService.getSystenProper();
        return "多模块项目 hello "+string;
    }
}
