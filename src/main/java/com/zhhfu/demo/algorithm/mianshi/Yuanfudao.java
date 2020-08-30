package com.zhhfu.demo.algorithm.mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/22 18:45
 * @description ：猿辅导笔试
 * @solution :
 */

public class Yuanfudao {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] arr = new int[n][2 * m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = m; j < 2 * m + 1; j++) {
                    arr[i][j] = arr[i][j - m];
                }
            }

            int[][] dp = new int[n][2 * m + 1];


        }
    }
}


/*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int length = in.nextInt();
            int[] data = new int[length+1];
            for (int i=0;i<length;i++){
                data[i] = in.nextInt();
            }
            if (length == 1){
                System.out.println(data[0]);
                continue;
            }
            if (length == 3){
                System.out.println(data[0] + " " + data[1] + " " + data[2]);
                continue;
            }
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            int everyNum = 2,begin = 1,end = 2;
            left.add(data[0]);
            for (int i=1;i<length;i++){
                if (length - end > everyNum * 2){
                    if (i == begin){
                        left.add(data[i]);
                    }
                    if (i == end){
                        right.add(data[i]);
                    }
                } else{
                    left.add(data[begin]);
                    int index = end;
                    while (index >= (end + (length - end)/2 -begin)){
                        right.add(data[index]);
                        index--;
                    }
                    i = end + 1;
                    while (i < length){
                        left.add(data[i]);
                        i++;
                    }
                }
                if (i == end){
                    begin = 2 * begin + 1;
                    end = 2 * end + 2;
                    everyNum = 2 *everyNum;
                }
            }
            for (Integer cur : left){
                System.out.print(cur + " ");
            }

            for (int i=right.size() - 1;i>= 0;i--){
                System.out.print(right.get(i));
                if (i != 0){
                    System.out.print(" ");
                }
            }
        }
    }
}
*/
