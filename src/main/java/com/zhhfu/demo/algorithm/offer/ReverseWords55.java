package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/17 21:10
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第55题 翻转句子
 */
public class ReverseWords55 {
    public static String reverseWords(String s) {
        if(s == null || s.trim().equals("")){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] strs = s.trim().split(" ");

        System.out.println(strs.length);
        for(int i=strs.length - 1;i>=0;i--){
            if (strs[i].equals("")){
                continue;
            }
            sb.append(strs[i]);
            if(i != 0){
                sb.append(" ");
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }
}
