package com.whmyit.api.service;

import com.whmyit.api.dto.Exposer;
import com.whmyit.api.dto.SeckillExecution;
import com.whmyit.api.entity.Seckill;
import com.whmyit.api.exception.SeckillException;

import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description: 秒杀相关服务
 * @Date: Created in 16:00  2018/11/8
 */
public interface SeckillService {


    /**
     * 秒杀商品列表
     * @return
     */
    List<Seckill> getSeckillList();


    /**
     * 秒杀商品详情
     * @param seckillId 根据商品id
     * @return 秒杀商品详情
     */
    Seckill getSeckill(long seckillId);


    /**
     * 秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作，可能失败，有可能成功，所以要抛出我们允许的异常
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException;


}
