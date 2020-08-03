package com.zhhfu.demo.algorithm.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/13 11:18
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第一题，发现数组中的重复数字
 */
public class FindRepeatNumber1 {
    public int findRepeatNumber1(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int[] bucket = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            bucket[nums[i]]++;
        }
        for(int i=0;i<nums.length;i++){
            if(bucket[i] > 1){
                return i;
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            } else{
                set.add(nums[i]);
            }
        }
        return -1;
    }

    public static int findRepeatNumber3(int[] nums){
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber3(arr));
    }
}
