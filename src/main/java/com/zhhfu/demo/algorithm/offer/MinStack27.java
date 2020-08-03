package com.zhhfu.demo.algorithm.offer;

import java.util.Stack;

/**
 * @author zhh_fu
 * @description 剑指offer第27题 最小栈
 * @date 2020/8/3 22:29
 * @solution
 */

public class MinStack27 {
    public Stack<Integer> stackA;
    public Stack<Integer> stackB;
    /** initialize your data structure here. */
    public MinStack27() {
        stackA = new Stack<Integer>();
        stackB = new Stack<Integer>();
    }

    public void push(int x) {
        stackA.push(x);
        if(stackB.isEmpty()){
            stackB.push(x);
        } else{
            int min = stackB.peek();
            if(min < x){
                stackB.push(min);
            } else{
                stackB.push(x);
            }
        }
    }

    public void pop() {
        stackA.pop();
        stackB.pop();
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        if(!stackB.isEmpty()){
            return stackB.peek();
        }
        return 0;
    }
}
