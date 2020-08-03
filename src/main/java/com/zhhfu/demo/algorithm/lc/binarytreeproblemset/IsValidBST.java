package com.zhhfu.demo.algorithm.lc.binarytreeproblemset;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

import java.util.Stack;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/17 11:00
 * @email ：fuzhihang5@jd.com
 * @description ：验证搜索二叉树
 * 需要注意，
 * 二叉搜索树要头结点的值要大于左子树的所有节点值，小于右子树的所有节点值
 * 它的中序遍历是升序。
 */
public class IsValidBST {
    public boolean isValidBST1(TreeNode root){
        if (root == null){
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if (root == null){
            return true;
        }
        if ((root.val >= max) || (root.val <= min)){
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public boolean isValidBST2(TreeNode head){
        if (head == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        long lower = 0;
        while (!stack.isEmpty() || head != null){
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else{
                head = stack.pop();
                if (head.val <= lower){
                    return false;
                }
                lower = head.val;
                head = head.right;
            }
        }
        return true;
    }
}
