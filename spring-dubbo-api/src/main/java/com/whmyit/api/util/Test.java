package com.whmyit.api.util;

import java.io.File;
import java.io.IOException;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 11:39  2018/6/6
 */
public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
//        FileUtils.copyFile(new File("E:\\log.log"),new File("E:\\log2.log")); //copy文件

        long start=System.currentTimeMillis();

        IOUtils.pringFileByReder(new File("E:\\钓竿.txt")); //copy文件
        long end=System.currentTimeMillis();

        System.out.println(end-start);




    }
}
