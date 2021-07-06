package com.demi.code.sorts;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {

    }

    /**
     * 归并排序的思想：
     *  (1) 开始，把每个元素看成一个已排序的序列，这样，n个元素就形成n个排序序列；
     *  (2) 对n个排序序列，每两个归并在一起，形成 n / 2 个排序序列，每个排序序列的长度为2（若n为奇数，有一个序列长度为1）；
     *  (3) 然后，对这 n / 2 个排序序列，每两个归并在一起，直到归并成一个排序序列，于是就完成了对n个元素的排序。
     * @param arr
     */
    public static void merge(int[] arr, int low, int mid, int high, int[] arrB) {
        // 合并序列的过程

    }
    public static void sort(int[] arrA, int low, int high, int[] arrB) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arrA, low, mid, arrB);
            sort(arrA, mid + 1, high, arrB);
            merge(arrA,low,mid,high,arrB);
        }

    }
}
