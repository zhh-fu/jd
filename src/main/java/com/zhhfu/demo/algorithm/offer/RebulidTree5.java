package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

import java.util.HashMap;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/13 18:13
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第五题 根据前序和中序遍历重建二叉树
 */
public class RebulidTree5 {
    public HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null){
            return null;
        }
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }

        int pivot = map.get(preorder[preStart]);
        TreeNode head = new TreeNode(preorder[preStart]);
        //这一步很关键，用于确定右子树的头节点
        int leftNum = pivot - inStart;
        head.left = helper(preorder, preStart + 1, inorder, inStart, pivot - 1);
        head.right = helper(preorder, preStart + leftNum + 1, inorder, pivot + 1, inEnd);
        return head;
    }

}
