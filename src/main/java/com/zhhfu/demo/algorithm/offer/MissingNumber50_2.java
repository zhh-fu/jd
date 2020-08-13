package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/13 21:39
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第50题第二种 0 ~ n - 1中缺失的数字
 */
public class MissingNumber50_2 {
    public int missingNumber1(int[] nums) {
        if(nums == null || nums.length == 0 || nums[0] != 0){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int res = 0;
        for (int i=0;i<nums.length;i++){
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

    public int missingNumber3(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        //注意这个地方，右边界是 数组的长度
        int left = 0, right = nums.length;
        while (left < right){
            int mid = ((right - left) >> 1) + left;
            if(nums[mid] != mid){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        return left;
    }
}
