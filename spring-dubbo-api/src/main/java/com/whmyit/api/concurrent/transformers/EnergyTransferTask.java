package com.whmyit.api.concurrent.transformers;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 18:01  2018/6/11
 */
public class EnergyTransferTask implements  Runnable {


    //共享的能量世界，载体
    private EnergySystem energySystem;

    //能量转移的能量盒子下标
    private int fromBox;

    //单元能量转移最大单位
    private double maxAmount;

    //做大休眠时间
    private int DELAY=10;

    public EnergyTransferTask() {
    }

    public EnergyTransferTask(EnergySystem energySystem, int fromBox, double maxAmount) {
        this.energySystem = energySystem;
        this.fromBox = fromBox;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {

        try {
            while (true){
                //随机某个盒子
                int toBox=(int)(energySystem.getBoxAmount()*Math.random());
                //随机转移数量
                double amount=maxAmount *Math.random();
                //转移能量
                energySystem.transfer(fromBox,toBox,amount);
                //休眠一会儿
                Thread.sleep((int)(DELAY*Math.random()));

            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
