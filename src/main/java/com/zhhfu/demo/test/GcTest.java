package com.zhhfu.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/16 15:44
 * @email ：fuzhihang5@jd.com
 * @description ：垃圾回收测试
 */
public class GcTest {
    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++) {
            List<String> list = new ArrayList<>();
            list.add("aaaaaaaaaaaaa");
        }
        System.gc();
    }
}
