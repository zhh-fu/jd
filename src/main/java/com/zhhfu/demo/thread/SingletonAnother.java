package com.zhhfu.demo.thread;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/31 14:25
 * @email ：fuzhihang5@jd.com
 * @description ：单例模式另一种写法
 */
public class SingletonAnother {
    private SingletonAnother(){}

    private static SingletonAnother instance = null;


    static {
        instance = new SingletonAnother();
    }

    public SingletonAnother getInstance(){
        return instance;
    }
}
