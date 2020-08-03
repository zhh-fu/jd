package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.ListNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/16 18:43
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第22题 合并两个有序链表使之有序
 */
public class MergeTwoLists22 {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(p1 != null && p2 != null){
            if(p1.val > p2.val){
                cur.next = p2;
                p2 = p2.next;
            } else{
                cur.next = p1;
                p1 = p1.next;
            }
            cur = cur.next;
        }
        cur.next = p1 == null ? p2 : p1;
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val > l2.val){
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        } else{
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
    }
}
