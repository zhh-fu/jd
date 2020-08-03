package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/14 14:56
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第十一题 机器人的运动范围
 */
public class MovingCount11 {
    public int movingCount(int m, int n, int k) {
        if(m < 1 || n < 1 || k < 1){
            return 1;
        }
        int[][] flag = new int[m][n];
        return helper(m, n, k, 0, 0, flag);
    }

    private int helper(int m, int n, int k, int row, int col, int[][] flag){
        if(row < 0 || row == m || col < 0 || col == n || flag[row][col] == 1){
            return 0;
        }
        if((row / 10 + row % 10 + col / 10 + col % 10) > k){
            return 0;
        }
        flag[row][col] = 1;
        int num = 1;
        num +=helper(m, n, k, row + 1, col, flag) + helper(m, n, k, row - 1, col, flag)
                + helper(m, n, k, row, col - 1, flag) + helper(m, n, k, row, col + 1, flag);
        return num;
    }
}
