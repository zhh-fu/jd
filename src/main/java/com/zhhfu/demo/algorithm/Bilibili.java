package com.zhhfu.demo.algorithm;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/9/4 19:22
 * @description ：Bilibili笔试
 * @solution :
 */

public class Bilibili {
    int index = 0;
    public static void main(String[] args) {
        Bilibili bzhan = new Bilibili();
        int[][] matrix = {
            {1, 2, 3},
            {5, 6, 7},
            {9,10,11},
            {13,14,15}
        };
        //int[] arr = bzhan.SpiralMatrix(matrix);
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int max = bzhan.GetMaxConsecutiveOnes(arr, 3);
        System.out.println(max);
    }


    public int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        int total = 0, num0 = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i] == 0){
                num0++;
            }
        }
        if (num0 <= k){
            return arr.length;
        }

        int p1 = 0, p2 = 0;
        int times = 0;
        int max = Integer.MIN_VALUE;
        while (p2 < arr.length){
            if (arr[p2] == 0){
                if (times == k){
                    while (arr[p1] == 1){
                        p1++;
                    }
                    p1++;
                } else{
                    times++;
                }
            }
            max = Math.max(p2 - p1 + 1, max);
            p2++;
        }
        return max;
    }





    public int[] SpiralMatrix (int[][] matrix) {
        // write code here
        if (matrix == null || matrix.length == 0){
            return new int[]{};
        }
        int lr = 0, lc = 0, rr = matrix.length - 1, rc = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        while (lr <= rr && lc <= rc){
            print(lr++,lc++,rr--,rc--,matrix,res);
        }
        return res;
    }

    private void print(int lr, int lc, int rr, int rc, int[][] matrix, int[] res){
        if (lr == rr){
            for (int i=lc;i<=rc;i++){
                res[index++] = matrix[lr][i];
            }
        } else if (lc == rc){
            for (int i=lr;i<=rr;i++){
                res[index++] = matrix[i][lc];
            }
        } else{
            for (int i=lc;i<rc;i++){
                res[index++] = matrix[lr][i];
            }
            for (int i=lr;i<rr;i++){
                res[index++] = matrix[i][rc];
            }
            for (int i=rc;i>lc;i--){
                res[index++] = matrix[rr][i];
            }
            for (int i=rr;i>lr;i--){
                res[index++] = matrix[i][lc];
            }
        }
    }
}
