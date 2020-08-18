package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/17 20:43
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第54题 两数之和
 */
public class TwoSum54 {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return new int[]{};
        }
        int p1 = 0, p2 = nums.length - 1;
        while(p1 < p2){
            while(p1 < p2 && nums[p1] + nums[p2] < target){
                p1++;
            }
            while(p1 < p2 && nums[p1] + nums[p2] > target){
                p2--;
            }
            if(nums[p1] + nums[p2] == target){
                return new int[]{nums[p1], nums[p2]};
            }
        }
        return new int[]{};
    }
}
