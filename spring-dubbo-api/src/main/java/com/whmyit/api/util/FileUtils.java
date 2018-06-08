package com.whmyit.api.util;

import java.io.*;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 10:24  2018/6/6
 */
public class FileUtils {
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


     /**
      * 拷贝挽剑  字节流
      * @param srcFile  原文件
      * @param destFile copy文件
      * @throws IOException
      */
     public  static void  copyFile(File srcFile,File destFile)throws IOException{
          if(!srcFile.exists()){
               throw new IllegalArgumentException("文件："+srcFile+"不存在");
          }
          if(!srcFile.isFile()){
               throw new IllegalArgumentException("文件："+srcFile+"不是文件");
          }
          FileInputStream in=new FileInputStream(srcFile);
          FileOutputStream out=new FileOutputStream(destFile); //自动创建
          //批量读写操作
          byte[] buf =new byte[1000*1024]; //1m
          int b;
          while ((b=in.read(buf,0,buf.length))!=-1){
               out.write(buf,0,b);
               out.flush();
          }
          in.close();
          out.close();
     }


     /**
      * 通过缓冲拷贝文件  字节流
      * @param srcFile
      * @param destFile
      * @throws IOException
      */
     public  static void  copyFileByBuff(File srcFile,File destFile) throws IOException, InterruptedException {
          if(!srcFile.exists()){
               throw new IllegalArgumentException("文件："+srcFile+"不存在");
          }
          if(!srcFile.isFile()){
               throw new IllegalArgumentException("文件："+srcFile+"不是文件");
          }

          BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));//缓冲读取
          BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(destFile));//缓冲写入

          int c;
          while((c=bis.read())!=-1){
               bos.write(c);
               bos.flush();//刷新缓冲区，否则写入不进去
          }
          bis.close();
          bos.close();
     }



     public static void copuFileByReder(File srcFile,File destFile) throws IOException {

          if(!srcFile.exists()){
               throw new IllegalArgumentException("文件："+srcFile+"不存在");
          }
          if(!srcFile.isFile()){
               throw new IllegalArgumentException("文件："+srcFile+"不是文件");
          }
          FileInputStream in=new FileInputStream(srcFile);
          InputStreamReader reder=new InputStreamReader(in);
//          int c;
//          while ((c=reder.read())!=-1){
//               System.out.print((char)c);
//          }
//
//          //批量读取
//          char[] buffer=new char[1000*1024];
//          int c;
//          //批量读取 ，放入到buffer 这个数组，从第0个位置开始放，做多放budder.length. i 返回读到的个数
//          while ((c=reder.read(buffer,0,buffer.length))!=-1){
//               String str=new String(buffer,0,c);
//               System.out.print(str);
//
//          }
     }







}
