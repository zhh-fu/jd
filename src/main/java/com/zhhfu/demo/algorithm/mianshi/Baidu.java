package com.zhhfu.demo.algorithm.mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/9/3 18:56
 * @description ：Baidu笔试
 * @solution :
 */

public class Baidu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int T = in.nextInt();
            for (int ii=0;ii<T;ii++){
                int cowNum = in.nextInt();
                int pointNum = in.nextInt();
                int[] flag = new int[cowNum+1];
                for (int i=0;i<pointNum;i++){
                    int point = in.nextInt();
                    for (int j=0;j<point;j++){
                        int begin = in.nextInt();
                        int end = in.nextInt();
                        if (begin == end){
                            flag[begin]++;
                            continue;
                        }
                        while (begin != end + 1){
                            flag[begin++]++;
                        }
                    }
                }
                int total = 0;
                List<Integer> list = new ArrayList<>();
                for (int i=1;i<=cowNum;i++){
                    if (flag[i] == pointNum){
                        total++;
                        list.add(i);
                    }
                }
                if (total == 0){
                    System.out.println(0);
                    System.out.println(0);
                    continue;
                }
                System.out.println(list.size());
                for (int i=0;i<total;i++){
                    System.out.print(list.get(i));
                    if (i != total - 1){
                        System.out.print(" ");
                    }
                }
            }
        }

    }
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (m == 1){
                if (n == 1){
                    System.out.println(1);
                } else{
                    System.out.println(0);
                }
            } else if (m == 2) {
                if (n == 1) {
                    System.out.println(1);
                } else if (n == 2) {
                    System.out.println(1);
                } else if (n == 3) {
                    System.out.println(2);
                }
            } else if (m == 3){
                if (n == 1) {
                    System.out.println(1);
                } else if (n == 2) {
                    System.out.println(1);
                } else if (n == 3) {
                    System.out.println(3);
                } else if (n == 4 || n== 5){
                    System.out.println(2);
                }
            } else if (m == 4){
                if (n <=2){
                    System.out.println(1);
                } else if (n == 3 || n == 4){
                    System.out.println(3);
                } else if (n == 5){
                    System.out.println(4);
                }
            } else if (m == 5){
                if (n <=2){
                    System.out.println(1);
                } else if (n == 3 || n == 4){
                    System.out.println(3);
                } else if (n == 5){
                    System.out.println(5);
                }
            }
        }
    }
    */
}
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int T = in.nextInt();
            for (int ii=0;ii<T;ii++){
                int cowNum = in.nextInt();
                int pointNum = in.nextInt();
                int[] flag = new int[cowNum+1];
                for (int i=0;i<pointNum;i++){
                    int point = in.nextInt();
                    for (int j=0;j<point;j++){
                        int begin = in.nextInt();
                        int end = in.nextInt();
                        if (begin == end){
                            flag[begin]++;
                            continue;
                        }
                        while (begin != end + 1){
                            flag[begin++]++;
                        }
                    }
                }
                int total = 0;
                List<Integer> list = new ArrayList<>();
                for (int i=1;i<=cowNum;i++){
                    if (flag[i] == pointNum){
                        total++;
                        list.add(i);
                    }
                }
                if (total == 0){
                    System.out.println(0);
                    System.out.println(0);
                    continue;
                }
                System.out.println(list.size());
                for (int i=0;i<total;i++){
                    System.out.print(list.get(i));
                    if (i != total - 1){
                        System.out.print(" ");
                    }
                }
            }
        }

    }

}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] arr = new int[n];
            int num0 = 0, num5 = 0;
            for (int i=0;i<n;i++){
                arr[i] = in.nextInt();
                if (arr[i] == 0){
                    num0++;
                }
                if (arr[i] == 5){
                    num5++;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (num5 < 9){
                System.out.println(-1);
                continue;
            }
            if (num0 == 0){
                System.out.println(-1);
                continue;
            }
            int mod = num5 % 9;
            while (num5 != mod){
                sb.append(5);
                num5--;
            }
            while (num0 != 0){
                sb.append(0);
                num0--;
            }
            System.out.println(sb.toString());
        }
    }
    */

