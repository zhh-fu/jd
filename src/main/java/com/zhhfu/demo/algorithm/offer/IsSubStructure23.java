package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.TreeNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/17 9:32
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第23题 树的子结构
 */
public class IsSubStructure23 {
    /*
    区分清楚树的子结构和树的子树的区别！
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        //B可能是A任何一个节点开始的子结构，
        //因此需要对  A的头结点和A的子节点  与  B  进行遍历
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode A, TreeNode B){
        //此处注意，B等于null需要放在前面判断
        //如果A为空直接返回false,但是如果此时B也为空，那么就会出错
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        if(A.val != B.val){
            return false;
        }
        //在进入后需要左右子树同时符合要求
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}
