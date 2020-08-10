package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/10 22:57
 * @description ：剑指offer第36题 数组中超过一半的数字
 * @solution :
 */

public class MajorityElement36 {
    public static int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int index = 1, cur = nums[0], times = 1;
        while(index < nums.length){
            if(times == 0){
                cur = nums[index];
                times = 1;
            } else{
                times = cur == nums[index] ? times + 1 : times - 1;
            }
            index++;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,9,9,10};
        System.out.println(majorityElement(arr));
    }
}
