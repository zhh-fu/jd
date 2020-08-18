package com.zhhfu.demo.algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/17 20:43
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第54题第二问 和为S的连续正数序列
 */
public class FindContinuousSequence54_2 {
    public static int[][] findContinuousSequence(int target) {
        if (target <= 0){
            return new int[][]{};
        }
        List<int[]> list = new ArrayList<>();
        int p1 = 0, p2 = 1, sum = 0;
        while (p2 <= target / 2 + 1){
            sum += p2;
            while (sum > target){
                p1++;
                sum -= p1;
            }
            if (sum == target){
                int[] tmp = new int[p2 - p1];
                for (int i=0;i< p2 - p1;i++){
                    tmp[i] = p1 + 1 + i;
                }
                list.add(tmp);
            }
            p2++;
        }

        int[][] res = new int[list.size()][];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findContinuousSequence(9));
    }
}
