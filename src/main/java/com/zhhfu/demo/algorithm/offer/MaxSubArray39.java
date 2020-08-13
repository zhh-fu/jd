package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/11 22:35
 * @description ：剑指offer第39题 子数组的最大和
 * @solution :
 */

public class MaxSubArray39 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int cur = nums[0], max = nums[0];
        for(int i=1;i<nums.length;i++){
            cur = Math.max(cur + nums[i], nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }
}
