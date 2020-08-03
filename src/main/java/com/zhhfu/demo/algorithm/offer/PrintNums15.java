package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/14 15:47
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第15题   打印从1到最大的n位数
 */
public class PrintNums15 {
    //不去考虑什么大数的问题了
    public int[] printNumbers(int n) {
        int res = 0;
        while(n != 0){
            res = res * 10 + 9;
            n--;
        }
        int[] num = new int[res];
        for(int i=0;i<res;i++){
            num[i] = i + 1;
        }
        return num;
    }
}
