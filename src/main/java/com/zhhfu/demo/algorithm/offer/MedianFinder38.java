package com.zhhfu.demo.algorithm.offer;

import java.util.PriorityQueue;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/11 21:33
 * @description ：剑指offer第38题 数据流的中位数
 * @solution :
 */

public class MedianFinder38 {
    /** initialize your data structure here. */
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    public MedianFinder38() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> (b - a));
    }

    public void addNum(int num) {
        if (max.size() == 0 || num < max.peek()){
            max.offer(num);
        } else{
            min.offer(num);
        }
        if (Math.abs(min.size() - max.size()) > 1){
            if (min.size() > max.size()){
                max.offer(min.poll());
            } else {
                min.offer(max.poll());
            }
        }
    }

    public double findMedian() {
        int minSize = min.size(), maxSize = max.size();
        if (minSize == maxSize){
            return (double) (min.peek() + max.peek()) / 2;
        } else if (minSize < maxSize){
            return (double) max.peek();
        } else {
            return (double) min.peek();
        }
    }
}
