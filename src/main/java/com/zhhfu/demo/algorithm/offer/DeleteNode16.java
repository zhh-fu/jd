package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.ListNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/14 15:49
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer16题 删除链表中的节点
 */
public class DeleteNode16 {
    public ListNode deleteNode1(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = head, pre = newHead;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                break;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return newHead.next;
    }

    public ListNode deleteNode2(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}
