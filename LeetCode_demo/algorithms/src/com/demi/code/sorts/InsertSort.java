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
     *  每次从未排序的序列段选出最小（或最大）的值，插入已经排好序的序列段。
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int N = arr.length;
        int i, j;
        // 需要进行排序的目标值
        int target;
        // 为什么不从下标0开始遍历：因为要保证有序元素段有元素，所以需要保留一个作为比较的基准。
        for (i = 1; i < N; i++) {
            j = i;
            target = arr[i];
            // 比较相邻两个元素，当目标值>=数组元素时，停止寻找
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 停止寻找后，插入target
            arr[j] = target;
        }

    }
}
