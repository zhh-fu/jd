package com.zhhfu.demo.algorithm.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/17 21:33
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第 56题 滑动窗口最大值
 */
public class MaxSlidingWindow56 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 1){
            return new int[]{};
        }
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i - q.peekFirst() >= k){
                q.pollFirst();
            }
            if(i >= k - 1){
                res[index++] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}
