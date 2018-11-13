package com.whmyit.service.dao;

import com.whmyit.api.entity.SuccessKilled;
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
 * @Date: Created in 15:43  2018/11/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.whmyit.service.dao")//将项目中对应的mapper类的路径加进来就可以了
public class SuccessKilledDaoTest {

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        int number = successKilledDao.insertSuccessKilled(1000, 13029121683l);
        System.out.println("insert successKilled dbnumber:"+number);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1000, 13029121683l);
        System.out.println(successKilled);

    }

}