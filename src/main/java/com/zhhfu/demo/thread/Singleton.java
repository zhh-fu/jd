package com.zhhfu.demo.thread;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/13 17:56
 * @email ：fuzhihang5@jd.com
 * @description ：单例模式，双重检查
 */
public class Singleton {
    //注意volatile关键字
    private static volatile Singleton instance;

    private Singleton(){ }

    //双重检测 + volatile防止指令重排序
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
