package com.zhhfu.demo.algorithm.sort;

/**
 * @author ：zhh_fu
 * @date ：Created in 2020/8/25 23:33
 * @description ：堆排序
 * @solution :
 */

public class HeapSort {
    private void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i=0;i<arr.length;i++){
            insertHeap(arr, i);
        }

        int size = arr.length;
        swap(arr, --size, 0);
        while (size > 0){
            heapify(arr, 0, size);
            swap(arr, --size, 0);
        }
    }

    private void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size){
            int right = left + 1;
            int largest = 0;
            if (right < size && arr[right] > arr[left]){
                largest = right;
            } else{
                largest = left;
            }
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private void insertHeap(int[] arr, int index) {
        while (arr[index] > arr[(index - 1)/2]){
            swap(arr, index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,6,3,7,23,67,45,34,989,3,2,8,4,3,9};
        new HeapSort().heapSort(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
