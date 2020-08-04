package com.zhhfu.demo.algorithm.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhh_fu
 * @description 剑指offer第28题 栈的压入弹出顺序
 * @date 2020/8/4 21:10
 * @solution
 */

public class ValidateStackSequences28 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null){
            return popped == null;
        }
        if(pushed.length == 0){
            return popped.length == 0;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0,i = 0;
        while(i<pushed.length){
            while(i < pushed.length && (stack.isEmpty() || stack.peek() != popped[index])){
                stack.push(pushed[i++]);
            }
            while(!stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        List<Integer> list = new ArrayList<>();

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5}, b = {4,5,3,2,1};
        System.out.println(validateStackSequences(a,b));
    }
}
