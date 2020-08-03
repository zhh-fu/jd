package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/13 14:32
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第三题 替换字符串中的空格为 %20
 */
public class ReplaceSpaceInString3 {
    public String replaceSpace(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
