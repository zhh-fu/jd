package com.zhhfu.demo.algorithm.lc.binarytreeproblemset;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/22 11:35
 * @email ：fuzhihang5@jd.com
 * @description ：二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 * 注意，不一定非要到达叶子节点，也不一定非要从根节点出发
 */
public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum = root.val;
        //只取正增益
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        //当前路径和
        int pathSum = root.val + left + right;
        //更新
        //这一操作决定了最大和可能是中间的某条路径，也就不用专门去遍历左右子树了
        max = Math.max(max, pathSum);
        //返回较大路径和
        return root.val + Math.max(left, right);
    }
}
