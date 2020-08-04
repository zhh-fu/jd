package com.zhhfu.demo.algorithm.offer;

/**
 * @author zhh_fu
 * @description 剑指offer第三十题 判断一个数组是否是二叉搜索树的后序遍历
 * @date 2020/8/4 22:33
 * @solution
 */

public class VerifyPostorder30 {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null || postorder.length == 0){
            return true;
        }
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int begin, int end){
        if(begin >= end){
            return true;
        }
        //遍历当前数组，然后看是否符合二叉搜索树的依据
        int p1 = begin;
        while(postorder[p1] < postorder[end]){
            p1++;
        }
        int m = p1;
        while(postorder[p1] > postorder[end]){
            p1++;
        }
        //注意此处的 p1 == end
        return p1 == end && helper(postorder, begin, m - 1) && helper(postorder, m, end - 1);
    }
}
