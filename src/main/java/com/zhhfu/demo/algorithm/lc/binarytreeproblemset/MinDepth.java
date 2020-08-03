package com.zhhfu.demo.algorithm.lc.binarytreeproblemset;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/20 11:13
 * @email ：fuzhihang5@jd.com
 * @description ：二叉树的最小深度，二叉树的最小深度为 根节点到最近叶子节点的深度
 */
public class MinDepth {
    public int minDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        //进行叶子节点的判断，叶子节点就直接返回
        if(root.left == null && root.right == null) {
            return 1;
        }
        //左右子树的深度
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        //左右子树有一个为空，那么为空子树深度为 0 ，返回另一个子树的深度 + 1 即可
        if(root.left == null || root.right == null){
            return left + right + 1;
        }
        //左右子树均不为空，范围最小值 + 1 即可
        return Math.min(left, right) + 1;
    }

    //BFS
    public int minDepth2(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i=0;i<size;i++){
                root = q.poll();
                if (root.left == null && root.right == null){
                    return depth;
                }
                if (root.left != null){
                    q.offer(root.left);
                }
                if (root.right != null){
                    q.offer(root.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
