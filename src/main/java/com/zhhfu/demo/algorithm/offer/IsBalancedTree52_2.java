package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/13 22:25
 * @email ：fuzhihang5@jd.com
 * @description ： 剑指offer第55题 平衡二叉树
 */
public class IsBalancedTree52_2 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root);
    }

    private boolean helper(TreeNode node){
        if(node == null){
            return true;
        }
        int left = depth(node.left);
        int right = depth(node.right);

        if(Math.abs(left - right) > 1){
            return false;
        }
        return helper(node.left) && helper(node.right);
    }

    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
