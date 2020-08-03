package com.zhhfu.demo.algorithm.lc.stackproblemset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/31 10:00
 * @email ：fuzhihang5@jd.com
 * @description ：Unix路径简化
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；
 * 此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，
 * 并且两个目录名之间必须只有一个斜杠 /。
 * 最后一个目录名（如果存在）不能以 / 结尾。
 * 此外，规范路径必须是表示绝对路径的最短字符串。
 */
public class SimplifyPath {
    //此题可使用String.split("/")进行简化
    public static String simplifyPath(String path) {
        if(path == null){
            return null;
        }
        if(path.equals("/") || path.equals("/.") || path.equals("/..")){
            return "/";
        }
        Stack<String> stack = new Stack<>();
        char[] chs = path.toCharArray();
        int i = 0;
        while(i < chs.length){
            if(chs[i] == '/'){
                i++;
                String str = "";
                while(i < chs.length && chs[i] != '/'){
                    str += chs[i];
                    i++;
                }
                if(str.equals("") || str.equals(".")){
                    continue;
                } else if(str.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    } else{
                        continue;
                    }
                } else{
                    stack.push(str);
                }
            }
        }
        String res = "/";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res.equals("/") ? res : res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
