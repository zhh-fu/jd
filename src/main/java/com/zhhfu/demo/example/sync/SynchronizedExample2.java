package com.zhhfu.demo.example.sync;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/8/3 14:55
 * @email ：fuzhihang5@jd.com
 */
public class SynchronizedExample2 {

    public synchronized void test(){
        System.out.println("this is a test!");
    }

    public void test1(){
        System.out.println("begin");
        synchronized (SynchronizedExample2.class){
            System.out.println("this is a test!");
        }
        System.out.println("end!");
    }
}
