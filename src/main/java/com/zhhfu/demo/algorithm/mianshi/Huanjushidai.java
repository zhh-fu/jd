package com.zhhfu.demo.algorithm.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/29 18:56
 * @description ：欢聚时代笔试
 * @solution :
 */

public class Huanjushidai {
    public long nextNarcissisticNumber (int n) {
        if (n <= 8) {
            return n + 1;
        }
        int times = 0;
        int cur = n;
        while (cur != 0){
            times++;
            cur = cur / 10;
        }
        if (times == 2){
            return getNum(3).get(0);
        }

        List<Long> list1 = getNum(times);
        if (n < list1.get(list1.size() - 1)){
            for (long num : list1){
                if (num > n){
                    return num;
                }
            }
        } else{
            return getNum(times+1).get(0);
        }
        return -1;
    }

    private List<Long> getNum(int n){
        List<Long> list = new ArrayList<>();
        for (long i = pow(10, n-1);i < pow(10, n);i++){
            long j = i;
            long sum = 0;
            while (j > 0){
                sum += pow(j % 10, n);
                j = j / 10;
            }
            if (sum == i){
                list.add(sum);
            }
        }
        return list;
    }

    private long pow(long a, long b){
        if (b == 0){
            return 0;
        }
        long num = 1;
        for (int i=0;i<b;i++){
            num = num * a;
        }
        return num;
    }

    public static void main(String[] args) {
        Huanjushidai test = new Huanjushidai();
        System.out.println(test.nextNarcissisticNumber(888));
    }
}


