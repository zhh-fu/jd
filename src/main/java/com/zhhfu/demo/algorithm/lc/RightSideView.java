package com.zhhfu.demo.algorithm.lc;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/9 19:44
 * @email ：fuzhihang5@jd.com
 * @description ：二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //list.add(root.val);
        int curNum = 0, sum = 0, next = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            curNum++;
            if (node.left != null){
                queue.add(node.left);
                sum++;
            }
            if (node.right != null){
                queue.add(node.right);
                sum++;
            }
            if (curNum == next){
                list.add(node.val);
                curNum = 0;
                next = sum;
                sum = 0;
            }
            /* 更简洁
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                    sum++;
                }
                if (node.right != null){
                    queue.add(node.right);
                    sum++;
                }

                if (i == size - 1){
                    list.add(node.val);
                }
            }
            */
        }
        return list;
    }
}
