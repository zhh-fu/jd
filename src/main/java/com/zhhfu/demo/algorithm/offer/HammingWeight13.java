package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/14 15:28
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第十三题 二进制中1的个数
 */
public class HammingWeight13 {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int num = 0;
        while(n != 0){
            if((n & 1) == 1){
                num++;
            }
            n = n >>> 1;
        }
        return num;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int num = 0;
        while(n != 0){
            num++;
            // n & (n - 1) 每执行一次就可以使 n 中 1 的个数减一
            n = n & (n - 1);
        }
        return num;
    }
}
