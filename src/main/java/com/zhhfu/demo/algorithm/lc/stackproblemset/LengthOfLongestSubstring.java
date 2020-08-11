package com.zhhfu.demo.algorithm.lc.stackproblemset;

import java.util.HashMap;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/6 17:41
 * @email ：fuzhihang5@jd.com
 * @description ：不含重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, max = Integer.MIN_VALUE;
        for (int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if (map.containsKey(ch)){
                left = Math.max(left, map.get(ch));
            }
            max = Math.max(max, right - left);
            map.put(ch, right);
        }
        return max;
    }
}
