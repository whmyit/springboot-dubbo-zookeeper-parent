package com.whmyit.service.dao;

import com.whmyit.api.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: whmyit@163.com
 * @Description: 秒杀明细
 * @Date: Created in 15:10  2018/11/7
 */
public interface SuccessKilledDao {

    /**
     * 插入否买明细
     * @param seckillId 秒杀id
     * @param userPhone 手机号
     * @return
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);


    /**
     * 查询秒杀明细（该对象携带秒杀商品对象）
     * @param seckillId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone") long userPhone);

}
