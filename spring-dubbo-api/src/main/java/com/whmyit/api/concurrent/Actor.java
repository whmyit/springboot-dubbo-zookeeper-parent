package com.whmyit.api.concurrent;

/**
 * @Author: whmyit@163.com
 * @Description: 线程先生 extends Thread 的表演
 * @Date: Created in 10:03  2018/6/11
 */
public class Actor extends Thread {
    @Override
    public void run() {

        System.out.println(getName()+"我是一个演员！");

        int count=0;
        boolean keepRuning=true;

        while (keepRuning){

            System.out.println(getName()+"登台演出 第 :"+ ++count+" 次");

            if(count==100)
                keepRuning=false;


            if(count%10==0)
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }

        System.out.println(getName()+"结束表演！");

    }


    public static void main(String[] args) {
        Thread actor=new Actor();
        actor.setName("Mr.Thread ");
        actor.start();


        Thread actress=new Thread(new Actress(),"Ms.Runnable");
        actress.start();
    }
}


/**
 *  Runnable 女士 内部类
 */
class Actress implements Runnable{

    public void run() {

        System.out.println(Thread.currentThread().getName()+"我是一个演员！");

        int count=0;
        boolean keepRuning=true;

        while (keepRuning){

            System.out.println(Thread.currentThread().getName()+"登台演出 第 :"+ ++count+" 次");

            if(count==100)
                keepRuning=false;


            if(count%10==0)
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }

        System.out.println(Thread.currentThread().getName()+"结束表演！");


    }
}
