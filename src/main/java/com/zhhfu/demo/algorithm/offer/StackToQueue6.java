package com.zhhfu.demo.algorithm.offer;

import java.util.Stack;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/13 19:36
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第六题 用栈表示队列
 */
public class StackToQueue6 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public StackToQueue6() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        } else if(!stack2.isEmpty()){
            return stack2.pop();
        } else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
