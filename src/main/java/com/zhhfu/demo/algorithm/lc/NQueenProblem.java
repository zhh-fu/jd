package com.zhhfu.demo.algorithm.lc;
import java.util.*;

/**
 * @author ：fuzhihang
 * @date ：Created in 2020/8/30 21:46
 * @description ：N皇后问题
 * @solution ：
 */
public class NQueenProblem {
    private Set<Integer> master = new HashSet<>();
    private Set<Integer> slave = new HashSet<>();
    private Set<Integer> col = new HashSet<>();
    private List<List<String>> list = new ArrayList<>();
    private int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        Stack<Integer> stack = new Stack<>();
        dfs(0, stack);
        return list;
    }

    private void dfs(int row, Stack<Integer> stack){
        if (row == n){
            List<String> subList = convert2Matrix(stack);
            list.add(subList);
            return;
        }

        for (int i=0;i<n;i++){
            //N皇后问题，需要判断每一行，每一列，主对角线和斜对角线
            //每一行一定不相同
            //每一列使用 i 代替即可
            //主对角线则是横纵坐标的差为一个定值
            //从对角线真实横纵坐标的和为一个定值
            if (!col.contains(i) && !master.contains(row - i) && !slave.contains(row + i)){
                stack.push(i);
                col.add(i);
                master.add(row - i);
                slave.add(row + i);

                dfs(row + 1, stack);

                slave.remove(row + i);
                master.remove(row - i);
                col.remove(i);
                stack.pop();
            }
        }
    }

    private List<String> convert2Matrix(Stack<Integer> stack){
        List<String> reList = new ArrayList<>();
        for (int num : stack){
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<n;i++){
                sb.append(".");
            }
            sb.replace(num, num + 1, "Q");
            reList.add(sb.toString());
        }
        return reList;
    }

    public static void main(String[] args) {
        new NQueenProblem();


        NQueenProblem nQueenProblem = new NQueenProblem();
        System.out.println(nQueenProblem.solveNQueens(4));
    }
}


