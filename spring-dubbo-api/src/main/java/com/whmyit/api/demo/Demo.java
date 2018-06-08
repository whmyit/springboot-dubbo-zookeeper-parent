package com.whmyit.api.demo;

import java.io.UnsupportedEncodingException;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 11:26  2018/6/4
 */
public class Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String s="慕课ABC1";

        System.out.println("GBK 汉字占用两个字节");

        //GBK 汉字占用两个字节
        byte[] bytes1=s.getBytes("GBK");


        for (byte byte1:bytes1) {
            System.out.print(Integer.toHexString(byte1 & 0xff )+" ");
        }

        System.out.println();

        //urf -8 汉字占用三个字节
        System.out.println("urf -8 汉字占用三个字节");
        byte[] bytes2=s.getBytes("UTF-8");


        for (byte byte2:bytes2) {
            System.out.print(Integer.toHexString(byte2 & 0xff )+" ");
        }


        System.out.println();

        //UTF-16be 用的是双字节编码  中文占用两个字节 英文占用两个字节
        System.out.println("UTF-16be 用的是双字节编码  中文占用两个字节 英文占用两个字节");
        byte[] bytes3=s.getBytes("UTF-16be");

        for (byte byte3:bytes3) {
            System.out.print(Integer.toHexString(byte3 & 0xff )+" ");
        }

        System.out.println();


        String str1=new String(bytes3);

        System.out.println(str1);

        //什么样的环境用什么样的编码不然会出错

        String str2=new String(bytes3,"UTF-16be");

        System.out.println(str2);



    }

}
