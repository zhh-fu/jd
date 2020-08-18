package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/18 22:45
 * @description ：剑指offer第60题 最大利润
 * @solution :
 */

public class MaxProfit60 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int cur = prices[0];
        int res = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > cur){
                res = Math.max(res , prices[i] - cur);
            } else{
                cur  = prices[i];
            }
        }
        return res;
    }
}
