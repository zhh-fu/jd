package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/12 22:32
 * @description ：剑指offer第50题 数组中元素的个数
 * @solution :
 */

public class Search50 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (right - left)/2 + left;
            if(nums[mid] < target){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        int count = 0;
        while(left < nums.length && nums[left++] == target){
            count++;
        }
        return count;
    }

    public int search2(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return 0;
        }
        return findBound(nums, target + 0.5) - findBound(nums, target - 0.5);
    }

    private int findBound(int[] nums, double target){
        int left = 0, right = nums.length - 1;
        int mid = (right - left) / 2 + left;
        while (left <= right){
            if (nums[mid] < target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
            mid = (right - left) / 2 + left;
        }
        return right;
    }
}
