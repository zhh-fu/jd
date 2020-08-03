package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/14 11:40
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第九题 旋转数组的最小数字
 */
public class MinInArray9 {
    public int minArray(int[] numbers) {
        if(numbers == null || numbers.length == 0){
            return 0;
        }

        for(int i=0;i<numbers.length - 1;i++){
            if(numbers[i] > numbers[i+1]){
                return numbers[i+1];
            }
        }
        //注意最后返回的这个值
        return numbers[0];
    }
}
