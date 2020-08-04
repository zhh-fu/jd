package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhh_fu
 * @description
 * @date 2020/8/4 21:31
 * @solution
 */

public class LevelOrder29 {
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
            list.add(node.val);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
