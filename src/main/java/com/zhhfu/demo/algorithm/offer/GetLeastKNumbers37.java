package com.zhhfu.demo.algorithm.offer;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/10 23:01
 * @description ：剑指offer第37题 数组中最小的k个数
 * @solution :
 */

public class GetLeastKNumbers37 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length){
            return new int[]{};
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i=0;i<arr.length;i++){
            pq.offer(arr[i]);
        }
        int[] res = new int[k];
        while (k != 0){
            res[k - 1] = pq.remove();
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        System.out.println(getLeastNumbers(arr,2));
    }
}
