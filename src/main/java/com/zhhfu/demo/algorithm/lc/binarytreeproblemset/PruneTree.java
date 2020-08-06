package com.zhhfu.demo.algorithm.lc.binarytreeproblemset;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/6 16:49
 * @email ：fuzhihang5@jd.com
 * @description ：二叉树的剪枝问题
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 *
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        return helper(root);
    }

    private TreeNode helper(TreeNode root){
        if(root == null){
            return null;
        }
        //因为子树可能被剪掉，需要更新
        root.left = helper(root.left);
        root.right = helper(root.right);
        //如果左右孩子均为空且当前节点值为0，剪掉
        if(root.left == null && root.right == null && root.val == 0){
            root = null;
        }
        return root;
    }
}
