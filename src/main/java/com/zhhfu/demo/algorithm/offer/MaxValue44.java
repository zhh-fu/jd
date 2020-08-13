package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/12 21:04
 * @description ：剑指offer第44题 最大价值
 * @solution : 可优化为空间复杂度为O(N)
 */

public class MaxValue44 {
    public int maxValue_2(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i=1;i<n;i++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public int maxValue(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i=1;i<n;i++){
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for(int i=1;i<m;i++){
            dp[0] = dp[0] + grid[i][0];
            for(int j=1;j<n;j++){
                dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n-1];
    }
}
