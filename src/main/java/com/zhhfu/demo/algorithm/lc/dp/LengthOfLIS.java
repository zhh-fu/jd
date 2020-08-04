package com.zhhfu.demo.algorithm.lc.dp;

import java.util.Arrays;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/4 17:31
 * @email ：fuzhihang5@jd.com
 * @description ：最长上升子序列
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1;i<dp.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
