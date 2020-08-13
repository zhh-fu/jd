package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/13 22:16
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第52题 二叉树的深度
 */
public class MaxDepth52 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
