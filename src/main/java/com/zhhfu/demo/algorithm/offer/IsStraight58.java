package com.zhhfu.demo.algorithm.offer;

import java.util.HashSet;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/18 21:56
 * @description ：剑指offer第58题 扑克牌顺子
 * @solution : 记住，一副牌里不可能有两张以上的大小王
 */

public class IsStraight58 {
    //法一，判大小
    public boolean isStraight(int[] nums) {
        if(nums == null || nums.length != 5){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        int max = 0, min = 13;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                continue;
            }
            //包含相同，提前返回
            if(set.contains(nums[i])){
                return false;
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            set.add(nums[i]);
        }

        if(max - min < 5){
            return true;
        }
        return false;
    }

    //法二排序，相差超过1则用0补，直到0用完
}
