package com.zhhfu.demo.test.javatest;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/9/2 21:07
 * @description ：测试1
 * @solution ：
 */
public class test1 {
    public static void main(String[] args) {
        int a = 123;
        Integer b = new Integer(123);
        Integer c = new Integer(123);
        Integer d = 123;
        System.out.println(a == b);
        System.out.println(a == d);
        System.out.println(b == c);
        System.out.println(b == d);
    }
}