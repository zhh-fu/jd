package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/13 22:12
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第51题 二叉搜索树的第K大的节点
 * @solution ： 也就是二叉搜索倒序遍历的第k个节点
 */
public class kthLargest51 {
    private int count = 0, ans = 0;
    public int kthLargest(TreeNode root, int k) {
        if(root == null || k < 1){
            return 0;
        }
        helper(root, k);
        return ans;
    }

    private void helper(TreeNode root, int k){
        if(root.right != null){
            helper(root.right, k);
        }
        if(++count == k){
            ans = root.val;
            return;
        }
        if(root.left != null){
            helper(root.left, k);
        }
    }
}
