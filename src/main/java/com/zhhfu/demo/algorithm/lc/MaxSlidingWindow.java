package com.zhhfu.demo.algorithm.lc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/6 17:21
 * @email ：fuzhihang5@jd.com
 * @description ：滑动窗口里的最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0){
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int index = 0;
        for(int i=0;i<nums.length;i++){
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if (i - dq.peek() == k){
                dq.poll();
            }
            if (i >= k - 1){
                res[index++] = dq.peek();
            }
        }
        return res;
    }
}
