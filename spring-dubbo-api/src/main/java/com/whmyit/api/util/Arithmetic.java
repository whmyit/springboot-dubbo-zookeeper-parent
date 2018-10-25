package com.whmyit.api.util;

/**
 * @Author: whmyit@163.com
 * @Description: 基础算法
 * @Date: Created in 10:23  2018/9/20
 */
public class Arithmetic {

    /**
     * 冒泡排序第一种方式
     *
     * @param array
     * @return 排序后的数组
     */
    public static int[] BubbleSort(int[] array) {
        // N个数字来排队 两两相比小靠前 外层循环N-1 内层循环 N-1-i
        int i, j;
        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) { //判断array[0]和array[1] 谁大谁小
                    int temp = array[j];   //把a[j]的值赋给temp;a[j]的值现在和temp相同;
                    array[j] = array[j + 1]; //把a[j+1]的值赋给a[j];a[j+1]的值现在和a[j]相同;
                    array[j + 1] = temp;     //把temp的值赋给a[j+1];从而完成互换;
                }
            }
        }
        return array;
    }


}
