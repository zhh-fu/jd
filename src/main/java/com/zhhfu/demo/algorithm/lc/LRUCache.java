package com.zhhfu.demo.algorithm.lc;

import javax.xml.soap.Node;
import java.util.HashMap;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/30 9:47
 * @email ：fuzhihang5@jd.com
 * @description ：最近最少使用 LRU  最不经常使用 LFU
 * LRU 采用HashMap 加 双向链表的方式处理，最不经常使用的靠近头部，最经常使用的靠近尾部，模拟的一个Entry下的情况
 * 使用HashMap去确定位置，使用虚拟节点作为头尾，减少了节点间的考虑
 */
public class LRUCache {

    HashMap<Integer, DoubleLinkedNode> cache;
    int size;
    int capacity;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        size = 0;
        this.capacity = capacity;
        //作为虚拟的头尾节点这样好处理
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        //有就更新并移至尾部
        if (node != null){
            node.value = value;
            moveToTail(node);
        } else{
            //没有则新建后移动到尾部
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            addToTail(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity){
                //注意这个地方
                //在删除原始节点后需要将map中的元素一并删除，并将size减一
                DoubleLinkedNode oldHead = head.next;
                removeNode(oldHead);
                size--;
                cache.remove(oldHead.key);
            }
        }
    }

    public void moveToTail(DoubleLinkedNode node){
        /*
        新元素移动到尾部，分为两步
        1、从原始位置断开
        2、添加到尾部
         */
        removeNode(node);
        addToTail(node);
    }

    public void addToTail(DoubleLinkedNode node){
        DoubleLinkedNode oldTail = tail.pre;
        //注意，添加到尾部时，需要处理两对节点间的关系
        oldTail.next = node;
        node.pre = oldTail;
        node.next = tail;
        tail.pre = node;
    }

    public DoubleLinkedNode removeNode(DoubleLinkedNode node){
        //从原始位置断开
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    //手动模拟双向链表
    class DoubleLinkedNode{
        Integer key;
        Integer value;
        //存储头尾信息
        DoubleLinkedNode pre;
        DoubleLinkedNode next;

        public DoubleLinkedNode(){

        }
        public DoubleLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
