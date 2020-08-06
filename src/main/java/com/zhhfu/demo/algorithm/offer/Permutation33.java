package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.SwapUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/6 21:44
 * @description ：剑指offer35题 字符串的子排列
 * @solution :
 */

public class Permutation33 {
    List<String> list = new ArrayList<>();
    public String[] permutation(String s) {
        if(s == null || s.equals("")){
            return new String[]{};
        }
        char[] chs = s.toCharArray();
        List<Character> subList = new ArrayList<>();
        helper(chs, 0);
        Collections.sort(list);
        return list.toArray(new String[0]);
    }

    private void helper(char[] chs, int i){
        if(i == chs.length - 1){
            String str = String.valueOf(chs);
            if (!list.contains(str)){
                list.add(str);
            }
        } else{
            for (int j = i;j<chs.length;j++){
                swap(chs, i, j);
                helper(chs,i+1);
                swap(chs, i, j);
            }
        }
    }

    private void swap(char[] chs, int i, int j){
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
