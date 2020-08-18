package com.zhhfu.demo.algorithm.offer;

import java.util.LinkedList;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/17 22:07
 * @email ：fuzhihang5@jd.com
 * @description ：剑指offer第56题 最大值队列
 */
public class MaxQueue56_2 {
    LinkedList<Integer> main;
    LinkedList<Integer> help;
    public MaxQueue56_2() {
        main = new LinkedList<>();
        help = new LinkedList<>();
    }

    public int max_value() {
        if(!help.isEmpty()){
            return help.peekFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        main.offer(value);
        if(help.isEmpty()){
            help.offer(value);
        } else{
            int size = main.size();
            while(!help.isEmpty() && help.peekLast() < value){
                help.pollLast();
            }
            while(help.size() != size){
                help.offer(value);
            }
        }
    }

    public int pop_front() {
        if(!main.isEmpty()){
            help.pollFirst();
            return main.pollFirst();
        }
        return -1;
    }

    public static void main(String[] args) {
        MaxQueue56_2 max = new MaxQueue56_2();
        max.push_back(1);
        max.push_back(2);
        System.out.println(max.max_value());
        System.out.println(max.pop_front());
        System.out.println(max.max_value());
    }
}
