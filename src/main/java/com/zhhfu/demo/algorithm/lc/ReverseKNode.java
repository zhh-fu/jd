package com.zhhfu.demo.algorithm.lc;

import com.zhhfu.demo.algorithm.basicConstructure.ListNode;

import java.util.Stack;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/1 15:27
 * @email ：fuzhihang5@jd.com
 * @description ：每K个翻转链表
 */
public class ReverseKNode {

    //myMethod , start， 时间复杂度O(N),空间复杂度 O(N)
    public static ListNode reverseKNode(ListNode head, int k){
        if (head == null || head.next == null || k < 2){
            return head;
        }
        //当前和左右边界
        ListNode cur = head, pre = null, next = null;
        ListNode newHead = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null){
            //当链表长度满足要求时，记录下右边界
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k){
                pre = helper(stack, pre, next);
                //通过这种方式来保证newHead只更新一次,就是第一次翻转完的当前节点
                newHead = newHead == head ? cur : newHead;
            }
            //更新到翻转前的 下一个节点，也就是右边界
            //不能使用 cur.next ！！！！
            //不能使用 cur.next ！！！！
            //不能使用 cur.next ！！！！
            //因为已经进行了续连，使用cur.next会变成它的上一个节点
            cur = next;
        }
        return newHead;
    }

    //注意形参的命名，很重要
    //所谓左边和右边，对应的是stack中的链表的左边界和右边界，需要进行重连
    private static ListNode helper(Stack<ListNode> stack, ListNode left, ListNode right){
        ListNode cur = stack.pop();

        //和左边界进行了重连
        if (left != null){
            left.next = cur;
        }

        //栈中的元素进行续连
        ListNode next = null;
        while (!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }

        //cur是当前链表的最后一个元素，需要和右边界进行续连
        cur.next = right;
        //续连完成后，cur就变成了新的左边界
        return cur;
    }

    private static ListNode reverseKNodeAnother(ListNode head, int k){
        if (head == null || head.next == null || k < 2){
            return head;
        }

        ListNode newHead = head, cur = head, pre = null, next = null, start = null;
        int count = 1;
        while (cur != null){
            next = cur.next;
            //满足条件开始翻转
            if (count == k) {
                //记录头节点
                newHead = newHead == head ? cur : newHead;
                //记录链表的开始节点，因为此时的链表还未翻转，因此直接使用pre.next
                start = pre == null ? head : pre.next;
                //翻转链表
                helperAnother(pre, start, next);
                count = 0;
                //更新左边界为初始的头结点，翻转后的尾节点
                pre = start;
            }
            cur = next;
            count++;
        }
        return newHead;
    }

    private static void helperAnother(ListNode left, ListNode start, ListNode right){
        ListNode cur = start, pre = null;
        //按照翻转链表操作即可，注意终止条件
        while (cur != right){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //和左边界相连
        if (left != null){
            left.next = pre;
        }
        //和右边界相连
        start.next = right;
    }

    //myMethod, end

    /*
    //网上的方法
    public static ListNode reverseNode(ListNode head, int k){
        if(k<2){
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode newHead = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur!=null){
            next = cur.next;
            stack.push(cur);
            if(stack.size() == k){
                pre=resign1(stack, pre, next);
                newHead = newHead==head ? cur : newHead;
            }
            cur = next;
        }
         return newHead;
}

    public static ListNode resign1(Stack<ListNode> stack, ListNode left, ListNode right){
        ListNode cur = stack.pop();
        if(left !=null){
            left.next=cur;
        }
        ListNode next=null;
        while(!stack.isEmpty()){
            next = stack.pop();
            cur.next=next;
            cur=next;
        }
        cur.next=right;
        return cur;
    }

*/

    private static void PrintList(ListNode head){
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[]args)
    {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        node.next.next.next.next.next=new ListNode(6);
        node.next.next.next.next.next.next=new ListNode(7);
        node.next.next.next.next.next.next.next=new ListNode(8);

        PrintList(node);
        //ListNode newHead = reverseKNodeAnother(node, 3);
        ListNode newHead1 = reverseKNode(node, 3);
        //PrintList(newHead);
        System.out.println("                            ");
        PrintList(newHead1);
    }
}
