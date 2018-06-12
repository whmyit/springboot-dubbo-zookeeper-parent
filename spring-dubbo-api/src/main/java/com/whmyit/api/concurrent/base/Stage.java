package com.whmyit.api.concurrent.base;

/**
 * @Author: whmyit@163.com
 * @Description: 隋唐演义舞台
 * @Date: Created in 10:39  2018/6/11
 */
public class Stage extends  Thread {


    public void run() {

        System.out.println("马上开始");



        //舞台秀线程休眠，尽情观看
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("开始");

        //舞台秀线程休眠，尽情观看
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();//隋军军队作战线程

        ArmyRunnable armyTaskOfRevolt=new ArmyRunnable();//农民军队作战线程

        Thread armyOfSuiDynasty= new Thread(armyTaskOfSuiDynasty,"【隋军】");

        Thread armyOfRevolt= new Thread(armyTaskOfRevolt,"【农民军】");


        //启动线程，让军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();


        //舞台秀线程休眠，尽情观看
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("半路杀出个程咬金！！！！！！！！！！！！！！");

        Thread mrCheng=new KeyPersonThread();
        mrCheng.setName("【程咬金】");

        System.out.println("志怀锐颖，气干强果，业预艰难，效宣行阵。入司禁卫，勤诚著於轩陛；出镇方隅，惠化洽於黎俗。畴庸有典，式隆宠命。！");

        //军地停止战争
        //停止线程
        armyTaskOfSuiDynasty.keepRunning=false;
        armyTaskOfRevolt.keepRunning=false;


        //
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mrCheng.start(); //历史人物开场

        try {
            mrCheng.join(); //获取权利直到使用结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束");

        System.out.println("8888");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
