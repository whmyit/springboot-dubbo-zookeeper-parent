package com.whmyit.api.concurrent.transformers;

/**
 * @Author: whmyit@163.com
 * @Description: 宇宙能量系统
 *                 遵循能量永恒定律
 *                 能量不能凭空消失，只能从一个地方转移到另一个地方
 * @Date: Created in 17:36  2018/6/11
 */
public class EnergySystem {

    //能量盒子，存储能量的地方
    private final double[] enersyBoxes;

    //私有的互斥对象
    private final  Object lockObject=new Object();


    /**
     * 初始化
     * @param n 能量盒子的数量
     * @param initialEnergy 每个盒子初始化含有的值
     */
    public EnergySystem(int n,double initialEnergy){
        enersyBoxes=new double[n];
        for (int i = 0; i < enersyBoxes.length; i++)
            enersyBoxes[i]=initialEnergy;
    }


    /**
     * 转移能量，从一个盒子转移到另一个盒子
     * @param from 能量源
     * @param to   能量终点
     * @param amount 能量值
     */
    public  void  transfer(int from,int to,double amount) throws InterruptedException {


        //对lockObject 加锁
        synchronized (lockObject){

//            if (enersyBoxes[from]<amount)
//                return;

            //while 循环，保证条件不满足是任务都会被条件阻挡
            //而不是继续竞争CPU资源
            //调用  lockObject.wait()
            //会在 wailt set 中等待
            while (enersyBoxes[from]<amount){
                lockObject.wait();  //线程等待，去掉锁
            }


            System.out.println(Thread.currentThread().getName());
            enersyBoxes[from]-=amount;
            System.out.printf("从%d转移%10.2f单位能量到%d",from,amount,to);
            enersyBoxes[to]+=amount;
            System.out.printf("能量总和：%10.2f%n",getTotalEnergies());

            //唤醒所有等待的线程
            lockObject.notifyAll();
        }

    }


    /**
     * 能量总数
     * @return
     */
     public double getTotalEnergies() {
        double sum=0;
        for (double amount:enersyBoxes)
            sum+=amount;
        return sum;
    }


    /**
     * 返回盒子长度
     * @return
     */
    public int getBoxAmount(){
        return enersyBoxes.length;
    }




}
