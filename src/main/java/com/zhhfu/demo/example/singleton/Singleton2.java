package com.zhhfu.demo.example.singleton;


import com.zhhfu.demo.annotations.SafeThread;

/**
 * 饿汉模式
 * 单例实例在类装载使用的时候进行创建
 */
@SafeThread
public class Singleton2 {

    private static Singleton2 instance = new Singleton2();

    private Singleton2(){

    }

    //静态的工厂方法
    public static Singleton2 getInstance(){
        return instance;
    }
}
