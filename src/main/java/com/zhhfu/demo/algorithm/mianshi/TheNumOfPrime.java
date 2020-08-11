package com.zhhfu.demo.algorithm.mianshi;

import java.util.Scanner;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/8 16:02
 * @description ：数组可拆成素数的个数
 * @solution :
 */

public class TheNumOfPrime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i=0;i<n;i++){
                arr[i] = in.nextInt();
            }
            //此处可能发生溢出
            //注意是一个AC的技巧
            long num = 0;
            for (int i=0;i<n;i++){
                num += getNum(arr[i]);
            }
            System.out.println(num);
        }
    }

    private static int getNum(int i){
        //其实不用判0
        if (i == 0 || i == 1){
            return 0;
        }
        return i / 2;
    }
}
