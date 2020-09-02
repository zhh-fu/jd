package com.zhhfu.demo.algorithm.mianshi;

import java.util.Scanner;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/9/2 19:20
 * @description ：华为笔试
 * @solution :
 */

public class Huawei {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int M = in.nextInt();
            char[][] isLand = new char[N][M];
            for (int i=0;i<N;i++){
                String str = in.next();
                char[] chs = str.toCharArray();
                isLand[i] = chs;
            }
            int res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (isLand[i][j] == 'S') {
                        res++;
                        infect(isLand, i, j, N, M);
                    }
                }
            }
            System.out.println(res);
        }
    }

    public static void infect(char[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 'S') {
            return;
        }
        m[i][j] = 'T';
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }
}
