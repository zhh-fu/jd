package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/16 17:59
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第19题 调整数组奇偶顺序
 */
public class ExchangeArraySort19 {
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        int p1 = 0, p2 = nums.length - 1;
        while(p1 < p2){
            while(p1 < p2 && (nums[p1] & 1) != 0){
                p1++;
            }
            while(p1 < p2 && (nums[p2] & 1) == 0){
                p2--;
            }
            int tmp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = tmp;
        }
        return nums;

    }
}
