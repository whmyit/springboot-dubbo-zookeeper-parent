package com.whmyit.api.concurrent.transformers;


/**
 * @Author: whmyit@163.com
 * @Description: 能量转移测试类
 * @Date: Created in 10:20  2018/6/12
 */
public class EnergySystemTest {

    public static final int BOX_AMOUNT=100; //能量盒子

    public static final double INITIAL_ENERGY=1000;//每个盒子初始化的能量


    public static void main(String[] args) {

        EnergySystem ens=new EnergySystem(BOX_AMOUNT,INITIAL_ENERGY); //能量世界

        for (int i = 0; i < BOX_AMOUNT; i++) {
            EnergyTransferTask task= new EnergyTransferTask(ens,i,INITIAL_ENERGY);
            Thread thread=new Thread(task,"能量块---"+i);
            thread.start();
        }





    }
}
