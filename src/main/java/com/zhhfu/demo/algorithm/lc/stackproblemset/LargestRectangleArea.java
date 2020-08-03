package com.zhhfu.demo.algorithm.lc.stackproblemset;

import java.util.Stack;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/30 14:40
 * @email ：fuzhihang5@jd.com
 * @description ：柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。
 * 每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        int n = heights.length, max = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        //寻找每一个位置的最左边小于它高度的位置
        for (int i=0;i<n;i++){
            //此处不可等于，因为如果等于就停了，就不是最左了
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            // -1代表当前位置上的左边没有小于它高度的地方
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        //寻找每一个位置的最右边小于它高度的位置
        for (int i=n-1;i>=0;i--){
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            //如果没有元素，代表其右边没有比它还低的存在
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i=0;i<n;i++){
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }
}
