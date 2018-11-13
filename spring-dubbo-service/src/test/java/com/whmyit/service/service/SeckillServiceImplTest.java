package com.whmyit.service.service;

import com.whmyit.api.dto.Exposer;
import com.whmyit.api.dto.SeckillExecution;
import com.whmyit.api.entity.Seckill;
import com.whmyit.api.service.SeckillService;
import com.whmyit.api.util.MD5Utill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 11:34  2018/11/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.whmyit.service.dao")//将项目中对应的mapper类的路径加进来就可以了
public class SeckillServiceImplTest {

    @Autowired
    private SeckillService seckillService;

    private long seckillId=1000;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list= seckillService.getSeckillList();
        for (Seckill seckill : list) {
            System.out.println(seckill.toString());
        }
    }

    @Test
    public void getSeckill() throws Exception {
        Seckill seckill = seckillService.getSeckill(seckillId);
        System.out.println(seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        System.out.println(exposer);
    }

    @Test
    public void executeSeckill() throws Exception {
        SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId,13021921682l, MD5Utill.getUrlMD5(seckillId));
        System.out.println(seckillExecution);
    }

}