package com.zhhfu.demo.algorithm.lc.binarytreeproblemset;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

import java.util.Stack;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/17 16:33
 * @email ：fuzhihang5@jd.com
 * @description ：二叉树遍历
 */
public class TreeTraversal {
    //
    public void preOrder(TreeNode head){
        if (head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            System.out.println(head.val);
            if (head.right != null){
                stack.push(head.right);
            }
            if (head.left != null){
                stack.push(head.left);
            }
        }
    }

    public void inOrder(TreeNode head){
        if (head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null){
            if (head != null){
                stack.push(head);
                head = head.left;
            } else{
                head = stack.pop();
                System.out.println(head.val);
                head = head.right;
            }
        }
    }

    public void postOrder(TreeNode head){
        if (head == null){
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()){
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null){
                stack1.push(head.left);
            }
            if (head.right != null){
                stack1.push(head.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().val);
        }
    }

    public void traversal(TreeNode head){
        if (head == null){
            return;
        }

        traversal(head.left);

        traversal(head.right);
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right = new TreeNode(6);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(7);

        TreeTraversal tt = new TreeTraversal();
        tt.postOrder(head);
        tt.traversal(head);
    }
}
