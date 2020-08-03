package com.zhhfu.demo.algorithm.lc.binarytreeproblemset;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/21 15:10
 * @email ：fuzhihang5@jd.com
 * @description ：二叉树中满足条件的路径
 */
public class HaveSumPath {
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
        //if判断条件
        if(root == null || sum < 0){
            return;
        }
        //满足条件
        if(sum == root.val && root.left == null && root.right == null){
            subList.add(root.val);
            list.add(new ArrayList<>(subList));
            subList.removeLast();
            return;
        }

        //做选择，添加元素
        subList.add(root.val);
        //继续递归
        helper(root.left, sum - root.val, subList);
        helper(root.right, sum - root.val, subList);
        //撤销选择
        subList.removeLast();
    }
}
