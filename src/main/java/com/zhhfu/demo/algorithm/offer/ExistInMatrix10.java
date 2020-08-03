package com.zhhfu.demo.algorithm.offer;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/14 14:37
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第十题  矩阵中的路径
 */
public class ExistInMatrix10 {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board == null || word == null){
            return false;
        }

        int[][] flag = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board, flag, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int[][] flag, int row, int col, int index, String word){
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0 || flag[row][col] == 1){
            return false;
        }
        if(board[row][col] != word.charAt(index)){
            return false;
        }
        if(index == word.length() - 1){
            return true;
        }
        //此处若不使用额外的flag，可以暂时将该位置变为一个不会出现的字符，如 * ，#
        //char tmp = board[row][col];
        //board[row][col] = '*';
        flag[row][col] = 1;
        boolean res = dfs(board, flag, row + 1, col, index + 1, word)
                   || dfs(board, flag, row - 1, col, index + 1, word)
                   || dfs(board, flag, row, col + 1, index + 1, word)
                   || dfs(board, flag, row, col - 1, index + 1, word);
        //完成后再进行回溯
        //board[row][col] = tmp;
        flag[row][col] = 0;
        return res;
    }
}
