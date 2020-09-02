package com.zhhfu.demo.algorithm.mianshi;

import java.util.Scanner;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/9/2 9:36
 * @description ：Shein笔试
 * @solution :
 */

public class Shein {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str1 = in.next();
            String str2 = in.next();
            if (str1 == null || str2 == null || str1.length() < str2.length()){
                System.out.println(0);
                continue;
            }
            char[] chs1 = str1.toCharArray();
            char[] chs2 = str2.toCharArray();
            int[] map = new int[256];
            for (int i=0;i<chs2.length;i++){
                map[chs2[i]]++;
            }
            int left = 0, right = 0, min = Integer.MAX_VALUE;
            int matchLength = chs2.length;
            while (right != chs1.length){
                map[chs1[right]]--;
                if (map[chs1[right]] >= 0){
                    matchLength--;
                }
                if (matchLength == 0){
                    while (map[chs1[left]] < 0){
                        map[chs1[left++]]++;
                    }
                    min = Math.min(min, right - left + 1);
                    matchLength++;
                    map[chs1[left++]]++;
                }
                right++;
            }
            if (min == Integer.MAX_VALUE){
                min = 0;
            }
            System.out.println(min);
        }
    }
}
