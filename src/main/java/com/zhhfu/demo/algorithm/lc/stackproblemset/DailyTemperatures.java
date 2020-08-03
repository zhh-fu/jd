package com.zhhfu.demo.algorithm.lc.stackproblemset;

import java.util.Stack;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/28 17:54
 * @email ：fuzhihang5@jd.com
 * @description ：每日温度问题
 * 请根据每日气温列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0){
            return null;
        }
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=res.length - 1;i>=0;i--){
            while(!stack.isEmpty() && T[stack.peek()] <= T[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
