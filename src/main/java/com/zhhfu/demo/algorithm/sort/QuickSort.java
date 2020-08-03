package com.zhhfu.demo.algorithm.sort;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/7/23 11:13
 * @email ：fuzhihang5@jd.com
 * @description ：快速排序
 */
public class QuickSort {
    public void quickSort(int[] arr, int i, int j){
        if (arr == null || arr.length < 2){
            return;
        }
        if (i < j){
            int pivot = (int) (Math.random() * (j - i + 1)) + i;
            swap(arr, pivot, j);
            int[] partition = partition(arr, i, j);
            quickSort(arr, i, partition[0] - 1);
            quickSort(arr, partition[1] + 1, j);
        }
    }

    private int[] partition(int[] arr, int left, int right){
        int less = left - 1, more = right, cur = left;
        while (cur < more){
            if (arr[cur] < arr[right]){
                swap(arr, cur++, ++less);
            } else if (arr[cur] > arr[right]){
                swap(arr, cur, --more);
            } else{
                cur++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,6,3,7,2,8,4,3,9};
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
