package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/13 20:02
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer 第八题 斐波那契数列进阶版，跳台阶
 */
public class Fibonacci8 {
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        if(n < 4){
            return n;
        }
        int res1 = 2, res2 = 3;
        for(int i=3;i<n;i++){
            int tmp = res2;
            res2 = (tmp + res1) % 1000000007;
            res1 = tmp;
        }
        return res2;
    }
}
