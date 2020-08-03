package com.zhhfu.demo.algorithm.lc.arrayproblemset;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/31 11:44
 * @email ：fuzhihang5@jd.com
 * @description ：数组的交集
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return null;
        }
        int[] arr = new int[Math.min(nums2.length, nums1.length)];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums1){
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                int count = map.get(num) - 1;
                map.put(num, count);
                arr[index++] = num;
            }
        }

        return Arrays.copyOfRange(arr,0,index);
    }
}
