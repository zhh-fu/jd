package com.zhhfu.demo.algorithm.mianshi;

import java.util.HashMap;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/23 9:45
 * @email ：fuzhihang5@jd.com
 * @description ：螺帽和螺母匹配
 * 假设有N个螺丝和N个螺帽混在一堆，你需要快速将它们配对。
 * 一个螺丝只会匹配一个螺帽，一个螺帽也只会匹配一个螺丝。
 * 你可以试着把一个螺丝和一个螺帽拧在一起看看谁大了，但不能直接比较两个螺丝或者两个螺帽。
 * 给出一个解决这个问题的有效方法。
 */
public class NutsAndBolts {
    //只适用于无重复元素
    public static void matchNutAndBolt(double[] nuts, double[] bolts){
        if (nuts == null || bolts == null){
            return;
        }
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i=0;i<bolts.length;i++){
            map.put(bolts[i],i);
        }
        for (int i=0;i<nuts.length;i++){
            if (map.containsKey(nuts[i])){
                int index = map.get(nuts[i]);
                swap(bolts, i, index);
                //这一步很重要，因为在比较完后bolts中元素的位置已经发生了变化
                //此时 index位置上新元素的位置就是bolts[index]
                map.put(bolts[index], index);
            }
        }
    }

    //基于快排的思想
    public void matchNutsAndBolts(double[] nuts, double[] bolts){
        if (nuts == null || bolts == null){
            return;
        }
    }

    private static void partition(double[] nuts, double[] bolts, int i, int j){
        int less = i - 1, more = j, cur = i;
        double nut = nuts[i];
        if (i < j){
            while (cur  < more){
                if (bolts[cur] < nut){
                    swap(bolts, cur++, ++less);
                } else if (bolts[cur] > nut){
                    swap(bolts, cur, more--);
                } else{
                    cur++;
                }
            }
            double bolt = bolts[less + 1];
            less = i - 1;
            more = j;
            cur = i;
            while (cur  < more){
                if (nuts[cur] < bolt){
                    swap(nuts, cur++, ++less);
                } else if (nuts[cur] > bolt){
                    swap(nuts, cur, more--);
                } else{
                    cur++;
                }
            }

            partition(nuts, bolts, i, less);
            partition(nuts, bolts, more, j);
        }
    }

    private static void swap(double[] arr, int i, int j){
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        double[] nuts = {1.1, 0.6, 0.3, 1.1, 0.8, 2.3, 1.3};
        double[] bolts = {0.3, 0.8, 1.1, 0.6, 2.3, 1.3, 1.1};
        //matchNutAndBolt(nuts, bolts);
        partition(nuts, bolts, 0, nuts.length - 1);
        for (int i=0;i<nuts.length;i++){
            System.out.print(bolts[i] + "   ");
            System.out.println(nuts[i]);
        }
    }
}
