package com.whmyit.api.util;

import com.whmyit.api.constant.ConstChar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 11:31  2018/6/6
 */
public class IOUtils {
    /**
     * 读取文件内容，按照16进制输出到控制台
     * 并且每10个换行
     * @param fileName
     */
    public static void printHex(String fileName) throws IOException{
        FileInputStream in=new FileInputStream(fileName);
        int b;
        int i=1;
        // in.read() 读取不到的时候是 -1
        while ((b=in.read())!=-1){
            //补0
//            System.out.println(b);
            if(b<=0xf){
                System.out.print(0);
            }
            System.out.print(Integer.toHexString(b)+"  ");
            if(i++%10==0){
                System.out.println();
            }
        }
        //关闭流
        in.close();
    }

    /**
     * 批量 读取文件内容，按照16进制输出到控制台
     * @param fileName
     * @throws IOException
     */
    public static void pringHexByByteArray(String fileName)throws IOException{
        FileInputStream in=new FileInputStream(fileName);
        // 1024 个字节是1K 相当于20K
        byte[] buf=new byte[1*1024];
        //从in中读取字节（批量）放入到buf字节数组中从 0个文字开始最多放buf.length 返回读到的字节个数
//        int bytes=in.read(buf,0,buf.length);//一次性读完说明数组足够大
//        int j=1;
//        for (int i = 0; i < bytes ; i++) {
//            if (buf[i]<=0xf)
//                System.out.print("0");
//            else
//                System.out.print(Integer.toHexString(buf[i])+" ");
//            if(j++%10==0)
//                System.out.println("");
//
//        }

        int bytes=0;
        int j=1;

        while ((bytes= in.read(buf,0,buf.length))!=-1){
            System.out.println("--------------------------------------------------------");
            System.out.println("----------------------------------------- bytes :"+bytes);;
            System.out.println("--------------------------------------------------------");
            for (int i = 0; i < bytes ; i++) {
                if (buf[i]<=0xf)
                    System.out.print("0");
                else
                    System.out.print(Integer.toHexString(buf[i] & 0xff)+"  "); //byt 类型8位 ，int32位 未必免转换错误 通过 0xff  将高24位清零
                if(j++%10==0)
                    System.out.println("");
            }
        }

    }


    public static void pringFileByReder(File srcFile) throws IOException {

        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件："+srcFile+"不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException("文件："+srcFile+"不是文件");
        }

        FileInputStream in=new FileInputStream(srcFile);
        InputStreamReader reder=new InputStreamReader(in);

        //批量读取
        char[] buffer=new char[8*1024];
        int c;
        //批量读取 ，放入到buffer 这个数组，从第0个位置开始放，做多放budder.length. i 返回读到的个数
        while ((c=reder.read(buffer,0,buffer.length))!=-1){
            String str=new String(buffer,0,c);
            System.out.print(str);

        }



    }


    /**
     * 遍历目录中的所有文件 字节流
     * @param file
     * @throws IOException
     */
    public static void listDirectory(File file)throws IOException{
        if(!file.exists())
            throw new IllegalArgumentException("目录 "+file+" 不存在");
        if(!file.isDirectory())
            throw new IllegalArgumentException(file+"  不是目录");

        File[] files =file.listFiles();
        if(files!=null && files.length>0){
            for (File filedir:files) {
                if(filedir.isDirectory())
                    listDirectory(filedir);
                else
                    System.out.println(filedir);
            }
        }

    }


}
