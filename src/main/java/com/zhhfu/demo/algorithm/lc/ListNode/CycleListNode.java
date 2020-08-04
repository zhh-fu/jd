package com.zhhfu.demo.algorithm.lc.ListNode;

import com.zhhfu.demo.algorithm.basicConstructure.ListNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/4 16:38
 * @email ：fuzhihang5@jd.com
 * @description ：环形链表问题
 */
public class CycleListNode {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        ListNode p1 = head.next, p2 = head.next.next;
        while(p1.val != p2.val){
            if(p2.next == null || p2.next.next == null){
                return null;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p2 = head;
        while (p1.val != p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
