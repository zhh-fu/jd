package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.ListNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/16 18:17
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第20题 链表中倒数第k个节点
 */
public class GetKthFromEnd20 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k < 1){
            return head;
        }
        ListNode p1 = head, p2 = head;
        while(k != 0){
            p1 = p1.next;
            k--;
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
