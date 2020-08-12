package com.zhhfu.demo.algorithm.offer;

import java.util.HashMap;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/12 21:59
 * @description ：剑指offer第45题 不含重复字符的最长子串
 * @solution : (left,right] 左闭右开
 */

public class LengthOfLongestSubstring45 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 1;
        //左闭右开区间
        for(int left = -1, right = 0;right < s.length();right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch));
            }
            max = Math.max(max, right - left);
            map.put(ch, right);
        }
        return max;
    }
}
