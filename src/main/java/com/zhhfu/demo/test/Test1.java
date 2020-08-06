package com.zhhfu.demo.test;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/2 17:36
 * @email ：fuzhihang5@jd.com
 * @description ：杂项测试代码
 */
public class Test1 {

    static boolean a1;
    static int aStatic = 2;
    static final int bStatic = 3;

    public static void main(String[] args) {
        /*
        Integer[] arr = {1,2,4,2,6,8,3,5,2,7,3,9,6,3};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list.stream().sorted((x,y) -> y - x).collect(Collectors.toList()));
        System.out.println(list.stream().limit(10).map(x -> x*x).collect(Collectors.toList()));
        System.out.println(list.stream().map(x -> x*x).distinct().collect(Collectors.toList()));
         */

        /*
        A a = new A();
        a.setHello("hello jd");
        a.setId(1);
        a.setWord("helloword");

        B b = new B();
        BeanUtils.copyProperties(a,b);
        b.setBusinessId(1);
        String jsona = JSON.toJSONString(a);
        String jsonb = JSON.toJSONString(b);
        System.out.println(jsona);
        System.out.println(jsonb);

         */

        /*
        Double a = 0.0, b = 0.1;
        for (int i=0;i<11;i++){
            a += 0.1;
        }
        b = b * 11;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.equals(b));
        System.out.println((0.1 + 0.2) == (double) 3/10);
        System.out.println((double) 3/10);
        System.out.println(0.1 + .2);
         */
        /**
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        String[] strs = list1.toArray(new String[0]);
        for (String str : strs){
            System.out.println(str);
        }

        Integer[] in = list.toArray(new Integer[0]);
        String a = "";
        System.out.println("".equals(a));
        boolean[] b2 = new boolean[2];
        System.out.println(a1);
        System.out.println(b2[1]);

        aStatic = 3;
        System.out.println(aStatic);
        System.out.println(bStatic);
         */
        List<String> oldMemberList = new ArrayList<>();
        List<String> developers = new ArrayList<>();
        oldMemberList.add("a");
        oldMemberList.add("b");
        oldMemberList.add("c");
        //developers.add("c");
        //developers.add("d");
        //developers.add("e");
        //List<String> oldMemberList = membersInfos.stream().map(member -> member.getErp()).collect(toList());
        //交集 => 更新
        /*
        List<String> updateList = developers.stream().filter(item -> oldMemberList.contains(item)).collect(toList());
        // 差集 (newIds - oldIds => 添加)
        List<String> addList = developers.stream().filter(item -> !oldMemberList.contains(item)).collect(toList());
        // 差集 (oldIds - newIds => 删除)
        List<String> deleteList = oldMemberList.stream().filter(item -> !developers.contains(item)).collect(toList());

        String s = "/.././/home/.../";
        String[] strs = s.split("/");
        for (String str : strs){
            System.out.println(str);
        }
        System.out.println(strs.length);

         */

        StringBuffer sb = new StringBuffer();
        String s = sb.toString();
        System.out.println(s.equals(""));
        System.out.println(s == null);
        System.out.println('b' - 'a');
    }


}

class A{
    private int id;
    private String word;
    private String hello;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}

class B{
    private int id;
    private String word;
    private String hello;
    private int businessId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }
}
