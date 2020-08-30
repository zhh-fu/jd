package com.zhhfu.demo.algorithm.mianshi;


import org.apache.catalina.Lifecycle;

import java.util.Scanner;

public class Shunfeng {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int length = in.nextInt();
            int[] data = new int[length];
            for (int i=0;i<length;i++){
                data[i] = in.nextInt();
            }

            int res = 0;
            int num1 = 0;
            int start = 0;
            int end = 0;
            for (int i=0;i<length;i++){
                if (data[i] == -1){
                    num1++;
                    continue;
                } else{
                    if (start == 0){
                        start = data[i];
                        if (num1 >= start){
                            res++;
                        }
                        end = start;
                        num1 = 0;
                    } else{
                        if ((num1 == 0 && data[i] - end == 1) || (num1 != 0 && data[i] - end - 1 == num1)){
                            end = data[i];
                            continue;
                        } else {
                            res++;
                            start = data[i];
                            end = data[i];
                        }
                    }
                }
            }
            res = res == 0 ? 1 : res + 1;
            System.out.println(res);
        }
    }
}
