package com.zhhfu.demo.algorithm.sort;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/25 23:25
 * @description ：归并排序
 * @solution :
 */

public class MergeSort {
    private void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left == right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] res = new int[right - left + 1];
        int p1 = left, p2 = mid + 1, index = 0;
        while (p1 <= mid && p2 <= right){
            if (arr[p1] < arr[p2]){
                res[index++] = arr[p1++];
            } else{
                res[index++] = arr[p2++];
            }
        }

        while (p1 <= mid){
            res[index++] = arr[p1++];
        }

        while (p2 <= right){
            res[index++] = arr[p2++];
        }

        for (int num : res){
            arr[left++] = num;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,6,3,7,23,67,45,34,989,3,2,8,4,3,9};
        new MergeSort().mergeSort(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
