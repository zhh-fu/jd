package com.zhhfu.demo.algorithm.lc.stackproblemset;

import java.util.Stack;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/29 10:12
 * @email ：fuzhihang5@jd.com
 * @description ：字符串解码
 */
public class DecodeString {
    //此答案不行

    /**
     * 解析数字的时候如果出现 100 这种情况，直接GG，
     * 因为是逆序输出的，所以最终结果为 1 而非 100
     */
    public static String decodeStrinError(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length;i++){
            if(chs[i] != ']'){
                stack.push(chs[i]);
            } else{
                StringBuffer sb = new StringBuffer();
                //获取新字符串
                while(stack.peek() != '['){
                    sb.append(stack.pop()) ;
                }
                sb = sb.reverse();
                String str = sb.toString();
                //弹出'['
                stack.pop();
                //获取次数
                int times = 0;
                while (!stack.isEmpty() && (stack.peek() >= '0' && stack.peek() <= '9')){
                    times = times * 10 + stack.pop() - '0';
                }
                //进行追加
                while (times != 1){
                    sb.append(str);
                    times--;
                }
                //再将新的字符串压入栈中
                int index = 0;
                while(index != sb.length()){
                    stack.push(sb.charAt(index));
                    index++;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    static int index = 0;
    public static String decodeString(String s){
        if (s == null || s.length() < 2){
            return s;
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        char[] chs = s.toCharArray();
        while (index != s.length()){
            if (chs[index] >= '0' && chs[index] <= '9'){
                int num = getNum(chs);
                numStack.push(num);
            } else if (chs[index] != ']'){
                if (chs[index] == '['){
                    strStack.push(chs[index] + "");
                    index++;
                } else{
                    String str = getString(chs);
                    strStack.push(str);
                }
            } else{
                index++;
                int times = numStack.pop();
                String tmp = strStack.pop();
                String res = "";
                while (times != 0){
                    res += tmp;
                    times--;
                }
                strStack.pop();
                if (!strStack.isEmpty()){
                    res = strStack.pop() + res;
                }
                strStack.push(res);
            }
        }
        return strStack.pop();
    }

    private static int getNum(char[] chs){
        int num = 0;
        while (chs[index] >= '0' && chs[index] <= '9'){
            num = num * 10 + chs[index] - '0';
            index++;
        }
        return num;
    }

    private static String getString(char[] chs){
        String str = "";
        while (chs[index] != ']'){
            str += chs[index];
            index++;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
