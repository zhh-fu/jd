package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhh_fu
 * @description 层序遍历，之字形打印
 * @date 2020/8/4 21:47
 * @solution
 */

public class LevelOrder29_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = false;
        int size = 0;
        q.offer(root);
        while(!q.isEmpty()){
            size = q.size();
            LinkedList<Integer> subList = new LinkedList<>();
            for (int i=0;i<size;i++){
                TreeNode node = q.poll();
                if (flag){
                    subList.offerFirst(node.val);
                } else {
                    subList.offerLast(node.val);
                }
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
            list.add(subList);
            flag = !flag;
        }
        return list;
    }
}
