package com.zhhfu.demo.algorithm.lc.binarytreeproblemset;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/20 10:26
 * @email ：fuzhihang5@jd.com
 * @description ：从1-n的数组成的搜索二叉树的数量
 * 本质上是递归的思想
 * 设root(N)为长度为n的序列可组成的搜索二叉树的个数
 * f(i,n)为以i为根节点，长度为n的搜索二叉树的个数
 * 那么 root(n) = f(1,n) + f(2,n) + ··· + f(n,n)
 * 而 f(i,n)又可以分为 左右子树， 左子树 i - 1 个节点，右子树 n - i 个节点
 * 注意到子树的数量和大小是没有关系的，因为可以同加同减
 * G(n)= (i=1)∑n G(i−1)*G(n−i)
 *
 * 不推荐递归法，费时太长
 */
public class NumOfTrees {
    //动态规划法
    public static int numTrees(int n) {
        if(n < 3){
            return n;
        }
        int[] root = new int[n + 1];
        root[0] = 1;
        root[1] = 1;
        root[2] = 2;

        for(int i=3;i<=n;i++){
            for(int j=1;j<=i;j++){
                root[i] = root[i] + root[j - 1] * root[n - j];
            }
        }
        return root[n];
    }

    //递归法
    public int numTrees2(int n) {
        if(n == 0 || n == 1){
            return 1;
        }

        int num = 0;
        for(int i=0;i<n;i++){
            num += numTrees(i) * numTrees(n - i - 1);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
}
