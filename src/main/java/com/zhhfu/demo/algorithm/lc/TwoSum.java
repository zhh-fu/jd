package com.zhhfu.demo.algorithm.lc;

import java.util.HashMap;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/3 17:03
 * @email ：fuzhihang5@jd.com
 * @description ：两数之和
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                arr[0] = i;
                arr[1] = map.get(target - nums[i]);
                return arr;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,2,4};
        System.out.println(twoSum(arr1,6)[1]);
    }
}
