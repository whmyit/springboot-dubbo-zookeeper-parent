package com.whmyit.api.concurrent.base;

/**
 * @Author: whmyit@163.com
 * @Description: 历史重要任务 程咬金
 * @Date: Created in 11:59  2018/6/11
 */
public class KeyPersonThread extends Thread {

    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始战斗！");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"左突突，右突突突，攻击隋军....");
        }
        System.out.println(Thread.currentThread().getName()+"结束战斗！");
    }
}
