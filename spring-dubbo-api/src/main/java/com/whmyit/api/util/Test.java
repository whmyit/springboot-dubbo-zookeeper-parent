package com.whmyit.api.util;

import com.whmyit.api.entity.StuSeria;
import com.whmyit.api.entity.SysInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 11:39  2018/6/6
 */
public class Test {

    public static void main(String[] args) throws Exception {
//        FileUtils.copyFile(new File("E:\\log.log"),new File("E:\\log2.log")); //copy文件

//        long start=System.currentTimeMillis();
//
//        FileUtils.copyFileByBufferReader(new File("E:\\钓竿.txt"),new File("E:\\钓竿1.txt")); //copy文件
//        long end=System.currentTimeMillis();
//
//        System.out.println(end-start);

//        //序列化
//        StuSeria sy=new StuSeria(0004,"whmyit@163.com",1302192168,"张三");
//        FileUtils.objectSeria(sy);

        //反序列化
        StuSeria sy=new StuSeria();
        sy= (StuSeria) FileUtils.deObjectSeria();
        System.out.println(sy);




    }
}
