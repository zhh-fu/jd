package com.zhhfu.demo.test.testPackage1;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/10 15:53
 * @email ：fuzhihang5@jd.com
 * @description ：测试数据类
 */
public class Person {
    private int id;
    private String name;
    private long age;
    private char sign;

    public Person() {
        System.out.println("a");
    }

    public Person(int id, String name, int age, char sign) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sign = sign;
    }

    public static void main(String[] args) {
        /*
        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
        int[] arr = {2,3};
        System.out.println(ClassLayout.parseClass(arr.getClass()).toPrintable());
        System.out.println(ClassLayout.parseClass(Node1.class).toPrintable());
        */
    }

    static class Node1{
        int a;
        int b;
        char c;
    }

}


