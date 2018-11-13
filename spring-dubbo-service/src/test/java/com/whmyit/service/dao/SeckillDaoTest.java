package com.whmyit.service.dao;

import com.whmyit.api.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 11:35  2018/11/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.whmyit.service.dao")//将项目中对应的mapper类的路径加进来就可以了
public class SeckillDaoTest {

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        int number=seckillDao.reduceNumber(1000,new Date());
        System.out.println("kill number is :"+number);
    }

    @Test
    public void queryId() throws Exception {
        long id=1000;
        Seckill seckill = seckillDao.queryId(id);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills= seckillDao.queryAll(0, 100);
        for (Seckill seckill:seckills){
            System.out.println(seckill);
        }
    }

}