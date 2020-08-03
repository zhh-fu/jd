package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

/**
 * @author zhh_fu
 * @description 剑指offer第25题 对称二叉树
 * @date 2020/8/3 21:42
 * @solution
 */

public class IsSymmetric25 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right){
        if(right == null){
            return left == null;
        }
        if(left == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
