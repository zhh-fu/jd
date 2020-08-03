package com.zhhfu.demo.algorithm.lc.hard;

import java.util.HashMap;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/30 14:14
 * @email ：fuzhihang5@jd.com
 * @description ：接雨水问题
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 解法：关于接雨水的问题，都是由较低的那一侧的高度决定的，那么移动的也是较低的那一侧的柱子
 * 如果在移动过程中遇到了更高的，那么就和另一侧的当前高度作比较，以此判断需要哪一边移动
 * 此外，在计算雨水时，不要试图用 最小高度x距离 ，这样是因为下面是凹凸不平的
 * 直接在遍历过程中使用当前top减去当前高度即可。
 */
public class TrapRain {
    public static int trapRain(int[] height) {
        if (height == null || height.length < 2){
            return 0;
        }
        //top 用于存储当前能接的最大雨水量
        int num = 0, top = 0;
        int leftMax = 0, rightMax = height.length - 1;
        while (leftMax < rightMax){
            //双指针相向遍历
            if (height[leftMax] < height[rightMax]){
                top = height[leftMax];
                leftMax++;
                //确保当前的top要高于他旁边的柱子才能接到雨水
                while (leftMax < rightMax && top >= height[leftMax]){
                    num += top - height[leftMax];
                    leftMax++;
                }
            } else{
                top = height[rightMax];
                rightMax--;
                while (leftMax < rightMax && top >= height[rightMax]){
                    num += top - height[rightMax];
                    rightMax--;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapRain(height));
    }
}
