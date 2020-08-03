package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.ListNode;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/16 18:18
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第21题 翻转链表
 */
public class ReverseList21 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head, pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
