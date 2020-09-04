package com.zhhfu.demo.test.javatest;

public interface InterfaceTest {
    public static final int a = 1;
    int b = 1;
    default void print(){
        System.out.println("this is a test");
    }
}
