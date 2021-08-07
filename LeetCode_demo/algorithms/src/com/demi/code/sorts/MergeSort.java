package com.demi.code.sorts;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 5, 4, 7};
        int[] arrB = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, arrB);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序的思想：
     *  (1) 开始，把每个元素看成一个已排序的序列，这样，n个元素就形成n个排序序列；
     *  (2) 对n个排序序列，每两个归并在一起，形成 n / 2 个排序序列，每个排序序列的长度为2（若n为奇数，有一个序列长度为1）；
     *  (3) 然后，对这 n / 2 个排序序列，每两个归并在一起，直到归并成一个排序序列，于是就完成了对n个元素的排序。
     * @param arr
     */
    public static void mergeAB(int[] arr, int low, int mid, int high, int[] arrB) {
        // 合并序列的过程
        // 临时数组的下标i
        int i = 0;
        // 左边序列起始索引j 和 右边序列起始索引k
        int j = low, k = mid + 1;
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                arrB[i++] = arr[j++];
            }
            else {
                arrB[i++] = arr[k++];
            }
        }
        // 若左边序列还有剩余，则将其全部拷贝近arrB数组中
        while (j <= mid) {
            arrB[i++] = arr[j++];
        }
        // 若右边序列还有剩余，则将其全部拷贝近arrB数组中
        while (k <= high) {
            arrB[i++] = arr[k++];
        }
        // 将结果还给arr数组
        for (int l = 0; l < i; l++) {
            arr[low + l] = arrB[l];
        }

    }
    public static void mergeSort(int[] arrA, int low, int high, int[] arrB) {
        if (low < high) {
            // 找到数组的中间位置元素的下标
            int mid = (low + high) / 2;
            // 左半边进行归并排序
            mergeSort(arrA, low, mid, arrB);
            // 右半边进行归并排序
            mergeSort(arrA, mid + 1, high, arrB);
            mergeAB(arrA,low,mid,high,arrB);
        }

    }
}
