package com.whmyit.service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.whmyit.api.Enum.SeckillEnum;
import com.whmyit.api.dto.Exposer;
import com.whmyit.api.dto.SeckillExecution;
import com.whmyit.api.entity.Seckill;
import com.whmyit.api.entity.SuccessKilled;
import com.whmyit.api.exception.SeckillException;
import com.whmyit.api.service.SeckillService;
import com.whmyit.api.util.MD5Utill;
import com.whmyit.service.dao.SeckillDao;
import com.whmyit.service.dao.SuccessKilledDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description: 秒杀相关业务
 * @Date: Created in 17:08  2018/11/8
 */
@Service  //该Service注解是dubbo的注解，不是spring的。若使用xml配置方式暴露接口，则不需要该注解。
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,10);
    }

    @Override
    public Seckill getSeckill(long seckillId) {
        return seckillDao.queryId(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill=seckillDao.queryId(seckillId);
        if (seckill == null) {
            return new Exposer(false,seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endtTime = seckill.getEndTime();
        Date now = new Date();
        //判断活动是否过期或未开启
        if (startTime.getTime()>now.getTime()||endtTime.getTime()<now.getTime()) {
            return new Exposer(false,seckillId,now.getTime(),startTime.getTime(),endtTime.getTime());
        }
        // MD5 加密url
        String md5=MD5Utill.getUrlMD5(seckillId);
        return new Exposer(true,md5,seckillId);
    }

    @Override
    @Transactional //秒杀是否成功 成功：减库存、插入秒杀明细；失败：事务回滚，抛出异常
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException {

        //MD5校验失败
        if (md5==null||!md5.equals(MD5Utill.getUrlMD5(seckillId))) {
            throw new SeckillException(SeckillEnum.END);
        }
        //执行秒杀
        Date now = new Date();
        try {
            int count = successKilledDao.insertSuccessKilled(seckillId, userPhone);
            if (count <= 0) {
                throw new SeckillException(SeckillEnum.DATE_REWRITE);
            } else {
                //热点商品竞争 ，update 行级锁时间
                int updateCount = seckillDao.reduceNumber(seckillId, now);
                if (updateCount <= 0) {
                    throw new SeckillException(SeckillEnum.REPEAT_KILL);
                } else {
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId,SeckillEnum.SUCCESS, successKilled);
                }

            }
        } catch (SeckillException e1) {
            throw e1;
        } catch (Exception e2) {
            logger.error(e2.getMessage(),e2);
            throw new SeckillException(SeckillEnum.INNER_ERROR);
        }

    }
}
