package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/5 21:53
 * @description ：剑指offer第31题 二叉树中和为某一值的路径
 * @solution :
 */

public class PathSum31 {
    public List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return list;
        }
        LinkedList<Integer> subList = new LinkedList<>();
        helper(root, sum, subList);
        return list;
    }

    private void helper(TreeNode root, int sum, LinkedList<Integer> subList){
        if (root == null){
            return;
        }
        subList.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null){
            list.add(new ArrayList<>(subList));
        }

        helper(root.left, sum, subList);
        helper(root.right, sum, subList);
        subList.removeLast();
    }
}
