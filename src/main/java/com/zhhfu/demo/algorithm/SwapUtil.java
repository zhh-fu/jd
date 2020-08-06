package com.zhhfu.demo.algorithm;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/6 21:45
 * @description ：数组交换工具类
 * @solution :
 */

public class SwapUtil {
    public static <T> void swap(T[] arr, int i, int j){
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
