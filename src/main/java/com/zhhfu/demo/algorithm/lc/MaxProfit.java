package com.zhhfu.demo.algorithm.lc;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/10 17:52
 * @email ：fuzhihang5@jd.com
 * @description ：最大利润进阶版
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        /**
         * 三种状态之间转化
         * 状态 0 为持有状态， 1 为未持有冷冻状态， 2为未持有非冷冻状态
         *
         * dp[i][j]代表 在第 i 天结束时，处于 j 状态下的利润，因此买入卖出都是基于今天的股票价格
         */
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i=1;i<prices.length;i++){
            //持有状态可以由 前一天持有状态 和 前一天未持有但是当天买入股票状态 转化而来
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            //未持有冷冻状态只能由 前一天持有当天卖出状态转 化
            dp[i][1] = dp[i-1][0] + prices[i-1];
            //未持有非冷冻状态可以由 前一天未持有非冷冻状态 和 前一天未持有冷冻状态 转化而来
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }
        //最后一天不能持有股票，这会损失利润，所以不考虑
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    //进阶版本，优化空间
    public int maxProfit_1(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int dp0 = -prices[0], dp1 = 0, dp2 = 0;
        for (int i=1;i<prices.length;i++){
            int tmp0 = Math.max(dp0, dp2 - prices[i]);
            int tmp1 = dp0 + prices[i];
            int tmp2 = Math.max(dp2, dp1);
            dp0 = tmp0;
            dp1 = tmp1;
            dp2 = tmp2;
        }
        return Math.max(dp1, dp2);
    }
}
