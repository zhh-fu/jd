package com.zhhfu.demo.algorithm.offer;

import java.util.HashMap;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/5 22:35
 * @description ：剑指offer第32题 复杂链表的复制
 * @solution : 使用hashmap，原来的节点当做key，复制的节点当做value
 */

public class CopyRandomList32 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        Node newHead = map.get(cur);
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}