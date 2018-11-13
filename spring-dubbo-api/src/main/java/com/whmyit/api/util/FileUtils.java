package com.whmyit.api.util;

import com.whmyit.api.constant.ConstChar;

import java.io.*;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 10:24  2018/6/6
 */
public class FileUtils {



     /**
      * 拷贝 字节流
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


     /**
      * 复制文件通过 字符流  InputStreamReader  OutputStreamWriter
      * @param srcFile
      * @param destFile
      * @throws IOException
      */
     public static void copuFileByReder(File srcFile,File destFile) throws IOException {

          if(!srcFile.exists()){
               throw new IllegalArgumentException("文件："+srcFile+"不存在");
          }
          if(!srcFile.isFile()){
               throw new IllegalArgumentException("文件："+srcFile+"不是文件");
          }
          FileInputStream in=new FileInputStream(srcFile);
          InputStreamReader reder=new InputStreamReader(in);

          FileOutputStream fo=new FileOutputStream(destFile);
          OutputStreamWriter ow=new OutputStreamWriter(fo);

//          int c;
//          while ((c=reder.read())!=-1){
//               System.out.print((char)c);
//          }
//
          //批量读取
          char[] buffer=new char[8*1024];
          int c;
          //批量读取 ，放入到buffer 这个数组，从第0个位置开始放，做多放budder.length. i 返回读到的个数
          while ((c=reder.read(buffer,0,buffer.length))!=-1){
//               String str=new String(buffer,0,c);
//               System.out.print(str);
               ow.write(buffer,0,c);
               ow.flush();
          }
          reder.close();
          ow.close();

     }


     /**
      * 文件流 不自动识别编码
      * @param srcFile
      * @param destFile
      */
     public static void copyFileByFileReader(File srcFile,File destFile) throws IOException{
          if(!srcFile.exists()){
               throw new IllegalArgumentException("文件："+srcFile+"不存在");
          }
          if(!srcFile.isFile()){
               throw new IllegalArgumentException("文件："+srcFile+"不是文件");
          }
          FileReader fr=new FileReader(srcFile);
          FileWriter we=new FileWriter(destFile);
//          FileWriter we=new FileWriter(destFile,true); 追加
          char[] buffer=new char[10*1024];
          int c;
          while ((c=fr.read(buffer,0,buffer.length))!=-1){
               we.write(buffer,0,c);
               we.flush();
          }
          fr.close();
          we.close();
     }


     /**
      * 字符流 通过
      * @param srcFile
      * @param destFile
      * @throws IOException
      */
     public static void copyFileByBufferReader(File srcFile,File destFile) throws IOException{
          if(!srcFile.exists()){
               throw new IllegalArgumentException("文件："+srcFile+"不存在");
          }
          if(!srcFile.isFile()){
               throw new IllegalArgumentException("文件："+srcFile+"不是文件");
          }

          //通过  BufferedReader 读取文件
          BufferedReader bfr=new BufferedReader(new InputStreamReader(new FileInputStream(srcFile),ConstChar.GBK));

          //通过 BufferedWriter 写文件
//          BufferedWriter bfw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFile)));
          PrintWriter pw =new PrintWriter(destFile);

          String line;
          while ((line=bfr.readLine())!= null){
//               bfw.write(line);
//               bfw.newLine();
//               bfw.flush();

               pw.println(line);
               pw.flush();
          }
          bfr.close();
//          bfw.close();

          pw.close();

     }


     /**
      * 序列化对象
      * @param obj
      */
     public static void  objectSeria(Object obj)throws Exception{
          ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("E:\\dat.dat"));
          oos.writeObject(obj);
          oos.flush();
          oos.close();
     }


     /**
      * 反序列化对象
      */
     public static Object  deObjectSeria()throws Exception{
          Object obj=new Object();
        ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream("E:\\dat.dat"));
          obj=inputStream.readObject();
          inputStream.close();
          return obj;
     }

}
