package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhh_fu
 * @description 层序遍历，每层打印
 * @date 2020/8/4 21:46
 * @solution
 */

public class LevelOrder29_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size = 0;
        while(!q.isEmpty()){
            size = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                subList.add(node.val);
            }
            list.add(subList);
        }
        return list;
    }
}
