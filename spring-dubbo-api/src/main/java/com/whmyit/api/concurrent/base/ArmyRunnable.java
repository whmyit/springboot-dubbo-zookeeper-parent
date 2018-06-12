package com.whmyit.api.concurrent.base;

/**
 * @Author: whmyit@163.com
 * @Description: 军队线程
 * @Date: Created in 10:23  2018/6/11
 */
public class ArmyRunnable implements Runnable {


    //volatile 保证线程可以正确读取其他线程写入的值
    //可见性 ref jmm happens-before 原则
    volatile boolean keepRunning=true;

    public void run() {
        while (keepRunning){
            for (int i=0; i<5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻方["+i+"]");
                Thread.yield(); // 让出CPU 的处理时间 ，下次谁进攻不一定
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束战斗");
    }

}
