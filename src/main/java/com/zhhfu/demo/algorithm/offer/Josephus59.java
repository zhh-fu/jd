package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/18 22:26
 * @description ：剑指offer第59 题 约瑟夫环问题
 * @solution :
 */

public class Josephus59 {
    //用数组模拟环，没有问题，但是会溢出
    public int lastRemaining(int n, int m) {
        if(m < 0 || n < 1){
            return 0;
        }
        int[] arr = new int[n];
        int count = 0, index = 0, cur = 1;
        while(count != n - 1){
            if(index == n){
                index = 0;
            }
            if(arr[index] == -1){
                index++;
                continue;
            }
            if(cur == m){
                arr[index] = -1;
                count++;
                cur = 0;
            }
            cur++;
            index++;
        }

        for(int i=0;i<n;i++){
            if(arr[i] == 0){
                return i;
            }
        }
        return -1;
    }

    //递推公式
    public int lastRemaining1(int n, int m) {
        int pos = 0;
        for (int i=2;i<=n;i++){
            pos = (pos + m) % i;
        }
        return pos;
    }
}
