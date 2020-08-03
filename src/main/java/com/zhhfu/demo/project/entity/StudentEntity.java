package com.zhhfu.demo.project.entity;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/1 11:43
 * @email ：fuzhihang5@jd.com
 * @description：：Student实体类
 */
public class StudentEntity {
    private int id;
    private String name;
    private int age;
    private int score;
    private String addr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
