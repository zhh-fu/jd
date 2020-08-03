package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/13 14:26
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第二题 在二维数组中查找
 */
public class FindNumberIn2DArray2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] > target){
                col--;
            } else if(matrix[row][col] < target){
                row++;
            } else{
                return true;
            }
        }
        return false;
    }
}
