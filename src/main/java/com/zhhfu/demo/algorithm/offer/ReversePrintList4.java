package com.zhhfu.demo.algorithm.offer;

import com.zhhfu.demo.algorithm.basicConstructure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/13 14:37
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第四题 从尾到头打印链表
 */
public class ReversePrintList4 {
    private List<Integer> list = new ArrayList<>();
    public int[] reversePrint1(ListNode head) {
        if(head == null){
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }

        int[] res = new int[stack.size()];
        for (int i=0;i<res.length;i++){
            res[i] = stack.pop();
        }
        return res;
    }

    //递归法，性能较差
    public int[] reversePrint2(ListNode head) {
        if(head == null){
            return new int[0];
        }
        helper(head);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void helper(ListNode head){
        if (head == null){
            return;
        }
        helper(head.next);
        list.add(head.val);
    }
}
