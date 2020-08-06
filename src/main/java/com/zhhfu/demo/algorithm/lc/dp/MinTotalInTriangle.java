package com.zhhfu.demo.algorithm.lc.dp;

import java.util.List;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/5 16:53
 * @email ：fuzhihang5@jd.com
 * @description ：三角形中最小路径和
 * 若要优化，可在原数组上进行优化 或者 因为只和上一组数据有关，优化为一维数组
 */
public class MinTotalInTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int m = triangle.size(), n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        //第一列元素
        for (int i=1;i<m;i++){
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        //注意斜边元素只能由斜对角元素到达
        for (int i=1;i<m;i++){
            dp[i][i] = dp[i - 1][i-1] + triangle.get(i).get(i);
        }
        //内部元素
        for (int i=2;i<m;i++){
            for (int j=1;j<=i-1;j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            if (min > dp[m-1][i]){
                min = dp[m-1][i];
            }
        }
        return min;
    }
}
