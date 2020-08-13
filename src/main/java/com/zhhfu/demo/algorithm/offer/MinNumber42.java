package com.zhhfu.demo.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/11 22:48
 * @description ：剑指offer第42题 把数组排成最小的数
 * @solution :
 */

public class MinNumber42 {
    //太慢了
    public String minNumber(int[] nums) {
        if (nums == null|| nums.length == 0){
            return "";
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums){
            list.add(num);
        }
        Collections.sort(list, new MyComparator());
        String res = "";
        for (int num : list){
            res += num;
        }
        return res;
    }

    class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 + "" + o2).compareTo(o2 + "" + o1);
        }
    }

    //可以直接转为String
    public String minNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; ++i)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs,(o1,o2) -> {
            return (o1+o2).compareTo(o2+o1);
        });
        StringBuilder sb = new StringBuilder();
        for(String s: strs)
            sb.append(s);
        return sb.toString();
    }
}


