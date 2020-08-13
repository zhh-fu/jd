package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.ListNode;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/12 22:02
 * @description ：剑指offer第49题 两个链表的第一个交点
 * @solution :
 */

public class GetIntersectionNode49 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        while(p1 != null || p2 != null){
            if(p1 == p2){
                return p1;
            }
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return null;
    }
}
