package com.zhhfu.demo.test.testPackage1;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/10 17:16
 * @email ：fuzhihang5@jd.com
 * @description ：Person 子类
 */
public class Student extends Person {
    public int grade;
    public String addr;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Student.class).toPrintable());
    }
}
