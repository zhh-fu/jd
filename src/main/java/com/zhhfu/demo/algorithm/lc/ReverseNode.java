package com.zhhfu.demo.algorithm.lc;

import com.zhhfu.demo.algorithm.basicConstructure.ListNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/8 15:54
 * @email ：fuzhihang5@jd.com
 * @description ：翻转链表
 */
public class ReverseNode {
    private static ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = null, cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static ListNode reverseList1(ListNode head){
        if (head == null || head.next == null){
            return head;
        } else {
            ListNode node = reverseList1(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode newHead = reverseList1(head);
        while (newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
