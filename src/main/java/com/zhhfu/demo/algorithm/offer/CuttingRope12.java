package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/14 14:58
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第十二题 剪绳子题1
 *                lc上第十三题 只是使绳子变长，需要对 1000000007 取余，不在赘述
 */
public class CuttingRope12 {
    //解法一，数学，可归纳看出
    public int cuttingRope1(int n) {
        if(n < 4){
            return n - 1;
        }
        int count3 = n / 3;
        int mod = n % 3;
        if(mod == 1){
            return (int)Math.pow(3,(count3 - 1)) * 4;
        } else if(mod == 2){
            return (int)Math.pow(3,count3) * 2;
        } else{
            return (int)Math.pow(3,count3);
        }
    }

    //解法二，dp
    public int cuttingRope2(int n) {
        if(n < 4){
            return n - 1;
        }
        //注意此处dp[i]代表当前绳子长度为 i 时可以组成的最大长度
        //此处不必分割为两段
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<=n;i++){
            int max = 0;
            //因为是对称的，所以遍历一半即可
            for(int j=0;j<=i/2;j++){
                int tmp = dp[j] * dp[i - j];
                if(tmp > max){
                    max = tmp;
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
