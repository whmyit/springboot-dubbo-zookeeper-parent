package com.whmyit.client.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.whmyit.api.entity.Seckill;
import com.whmyit.api.service.SeckillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description: SeckillW WEB Request
 * @Date: Created in 10:51  2018/11/13
 */
@RequestMapping("seckill")
@RestController()
public class SeckillController {

    @Reference //dubbo 注解
    private SeckillService seckillService;

    @GetMapping("/{seckillId}/detail")
    public Seckill getSeckill(@PathVariable("seckillId") long seckillId) {
        return seckillService.getSeckill(seckillId);
    }

    @GetMapping("/list")
    public List<Seckill> getSeckillList() {
        return seckillService.getSeckillList();
    }



}
