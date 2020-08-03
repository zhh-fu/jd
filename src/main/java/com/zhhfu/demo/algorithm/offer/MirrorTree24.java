package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

/**
 * @author zhh_fu
 * @description 剑指offer第24题，树的镜像
 * @date 2020/8/3 21:32
 * @solution
 */

public class MirrorTree24 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
