package com.zhhfu.demo.algorithm.mianshi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/9/1 19:02
 * @description ：pdd笔试
 * @solution :
 */

public class Pdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int bag = in.nextInt();
            int length = in.nextInt();

            int[] weight = new int[length];
            int[] value = new int[length];
            for (int i = 0; i < length; i++) {
                weight[i] = in.nextInt();
            }
            for (int i = 0; i < length; i++) {
                value[i] = in.nextInt();
            }

            int[][] dp = new int[length + 1][bag + 1];
            for (int i = length - 1; i >= 0; i--) {
                for (int j = bag; j >= 0; j--) {
                    dp[i][j] = dp[i + 1][j];
                    if (j + weight[i] <= bag) {
                        dp[i][j] = Math.max(dp[i][j], value[i] + dp[i + 1][j + weight[i]]);
                    }
                }
            }

            System.out.println(dp[0][0]);
        }
    }
}
            /*
            int N = bag * 2 + 8;
            int[] dp = new int[N];
            for (int i = 0; i < N; i++) {
                dp[i] = Integer.MIN_VALUE;
            }
            dp[bag] = 0;
            for (int i = 0; i < length; i++) {
                if (weight[i] > 0) {
                    for (int j = N; j >= weight[i]; j--) {
                        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                    }
                } else {
                    for (int j = 0; j < N + weight[i]; j++) {
                        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                    }
                }
            }
            int ans = 0;
            for (int i = bag; i < N; i++) {
                if (dp[i] > 0) {
                    ans = Math.max(ans, dp[i] + i - bag);
                }
            }
            System.out.println(ans);
            */
/*
    private static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            int length = in.nextInt();
            int[] matrix = new int[length];
            boolean flag = false;
            for (int i=0;i<length;i++){
                matrix[i] = in.nextInt();
                if (matrix[i] == 1){
                    flag = true;
                }
            }
            if (flag){
                System.out.println(num);
                continue;
            }
            int[] dp = new int[length];
            for (int i=length - 1;i>=0;i--){
                isMod(matrix[i], num);
            }
            System.out.println(set.size());
        }
    }

    private static int isMod(int mod, int num){
        int cur = 1, total = 0;
        while (cur < num + 1){
            if (cur % mod == 0){
                set.add(cur);
                total++;
            }
            cur++;
        }
        return total;
    }

}
    /*
    private static int[][] matrix = null;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            matrix = new int[n][n];
            int lr = 0, lc = 0, rr = n - 1, rc = n - 1;

            while (lr < rr){
                assign(lr++,lc++,rr--,rc--,n);
            }

            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    System.out.print(matrix[i][j]);
                    if (j == n - 1){
                        System.out.println();
                    } else{
                        System.out.print(" ");
                    }
                }
            }
        }
    }

    private static void assign(int lr, int lc, int rr, int rc, int n){
        if (n % 2 == 0){
            for (int i=lc+1;i< n/2;i++){
                matrix[lr][i] = 2;
            }
            for (int i=n/2;i<rc;i++){
                matrix[lr][i] = 1;
            }
            for (int i=lr+1;i< n/2;i++){
                matrix[i][rc] = 8;
            }
            for (int i=n/2;i<rr;i++){
                matrix[i][rc] = 7;
            }
            for (int i=rc-1;i>=n/2;i--){
                matrix[rr][i] = 6;
            }
            for (int i=n/2-1;i>lc;i--){
                matrix[rr][i] = 5;
            }
            for (int i=rr-1;i>=n/2;i--){
                matrix[i][lc] = 4;
            }
            for (int i=n/2-1;i>lr;i--){
                matrix[i][lc] = 3;
            }
        } else{
            for (int i=lc+1;i< n/2;i++){
                matrix[lr][i] = 2;
            }
            for (int i=n/2+1;i<rc;i++){
                matrix[lr][i] = 1;
            }
            for (int i=lr+1;i< n/2;i++){
                matrix[i][rc] = 8;
            }
            for (int i=n/2+1;i<rr;i++){
                matrix[i][rc] = 7;
            }
            for (int i=rc-1;i>n/2;i--){
                matrix[rr][i] = 6;
            }
            for (int i=n/2-1;i>lc;i--){
                matrix[rr][i] = 5;
            }
            for (int i=rr-1;i>n/2;i--){
                matrix[i][lc] = 4;
            }
            for (int i=n/2-1;i>lr;i--){
                matrix[i][lc] = 3;
            }
        }

    }


}


}
/*

}
*/
