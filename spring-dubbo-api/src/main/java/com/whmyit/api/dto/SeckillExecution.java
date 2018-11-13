package com.whmyit.api.dto;

import com.whmyit.api.Enum.SeckillEnum;
import com.whmyit.api.entity.SuccessKilled;

import java.io.Serializable;

/**
 * @Author: whmyit@163.com
 * @Description: 秒杀执行结果
 * @Date: Created in 16:42  2018/11/8
 */
public class SeckillExecution implements Serializable {

    private long seckillId;

    //秒杀执行的结果状态
    private int state;

    //状态明文表示
    private String sateInfo;

    //秒杀成功返回内容
    private SuccessKilled successKilled;

    //秒杀成功
    public SeckillExecution(long seckillId, SeckillEnum seckillEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = seckillEnum.getCode();
        this.sateInfo = seckillEnum.getMsg();
        this.successKilled = successKilled;
    }

    //秒杀失败
    public SeckillExecution(long seckillId, SeckillEnum seckillEnum) {
        this.seckillId = seckillId;
        this.state = seckillEnum.getCode();
        this.sateInfo = seckillEnum.getMsg();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSateInfo() {
        return sateInfo;
    }

    public void setSateInfo(String sateInfo) {
        this.sateInfo = sateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", sateInfo='" + sateInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }
}
