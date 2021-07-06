package com.demi.code.sorts;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 6, 5};
        InsertSort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int N = arr.length;
        int i, j;
        // 需要进行排序的目标值
        int target;
        for (i = 1; i < N; i++) {
            j = i;
            target = arr[i];
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }

    }
}
