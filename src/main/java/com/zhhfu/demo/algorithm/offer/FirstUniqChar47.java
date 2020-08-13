package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/12 22:00
 * @description ：剑指offer47题 字符串中第一个只出现一次的字符
 * @solution :
 */

public class FirstUniqChar47 {
    public char firstUniqChar(String s) {
        if(s == null || s.trim().equals("")){
            return ' ';
        }
        char[] chs = s.toCharArray();
        int[] count = new int[26];
        for(char ch : chs){
            count[ch - 'a']++;
        }
        //这个地方是精髓
        for(char ch : chs){
            if(count[ch - 'a'] == 1){
                return ch;
            }
        }
        return ' ';
    }
}
