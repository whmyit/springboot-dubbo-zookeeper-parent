package com.whmyit.service.dao;

import com.whmyit.api.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description: seckill dao
 * @Date: Created in 15:02  2018/11/7
 */
public interface SeckillDao {


    /**
     * 件库存
     * @param seckillId
     * @param killTime
     * @return 如果返回结果>1，表示更新库存记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    /**
     * 更具id查询秒杀商品详情
     * @param seckillId
     * @return
     */
    Seckill queryId(long seckillId);


    /**
     * 查询秒杀列表带分页
     * @param off
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("off") int off,@Param("limit")  int limit);

}
