package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/13 19:49
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第七题 斐波那契数列
 */
public class Fibonacci7 {
    public static int fib1(int n) {
        if (n < 2){
            return n;
        }
        int res1 = 0, res2 = 1;
        for (int i=1;i<n;i++){
            int tmp = res2;
            res2 = (res1 + tmp) % 1000000007;
            res1 = tmp;
        }
        return res2 ;
    }

    public static int fib2(int n) {
        if (n < 2){
            return n;
        }
        return fib2(n - 1) % 1000000007 + fib2(n - 2) % 1000000007;
    }
}
