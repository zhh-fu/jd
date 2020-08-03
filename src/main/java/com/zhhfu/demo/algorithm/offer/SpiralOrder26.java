package com.zhhfu.demo.algorithm.offer;

/**
 * @author zhh_fu
 * @description 剑指offer第26题 顺时针打印矩阵
 * @date 2020/8/3 22:10
 * @solution
 */

public class SpiralOrder26 {
    int index = 0;
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        int m = matrix.length, n = matrix[0].length;
        int[] arr = new int[m*n];
        int upRow = 0, upCol = 0, downRow = m - 1, downCol = n - 1;
        while(upRow <= downRow && upCol <= downCol){
            print(matrix,arr,upRow++,upCol++,downRow--,downCol--);
        }
        return arr;
    }

    private void print(int[][] matrix, int[] arr, int lr, int lc, int rr, int rc){
        if(lr == rr){
            while(lc <= rc){
                arr[index++] = matrix[lr][lc++];
            }
        }else if(lc == rc){
            while(lr <= rr){
                arr[index++] = matrix[lr++][rc];
            }
        } else{
            for(int i=lc;i<rc;i++){
                arr[index++] = matrix[lr][i];
            }
            for(int i=lr;i<rr;i++){
                arr[index++] = matrix[i][rc];
            }
            for(int i=rc;i>lc;i--){
                arr[index++] = matrix[rr][i];
            }
            for(int i=rr;i>lr;i--){
                arr[index++] = matrix[i][lc];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{3},{2}};
        System.out.println(new SpiralOrder26().spiralOrder(matrix));
    }
}
