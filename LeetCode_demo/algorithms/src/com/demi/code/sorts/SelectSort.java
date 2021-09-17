package com.demi.code.sorts;

import java.util.Arrays;

/**
 * 选择排序
 *
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6};
        SelectSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 选择排序的实现
     *  每次从数组中选出最小的元素放在当前数组的第一个位置。
     *  原理：每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。
     *  也就是：每一趟在n-i+1(i=1，2，…n-1)个记录中选取关键字最小的记录作为有序序列中第i个记录。
     *  每次比较大小都是和当前数组的第一个元素i作比较，即nums[j]与nums[i]作比较。
     *  当前数组（内循环）的起始位置是i + 1，表示已有多少个数排成序了，不需要再排了。
     *  基于此思想的算法主要有简单选择排序、树型选择排序和堆排序。（这里只介绍常用的简单选择排序）
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int N = arr.length;
        int lowIndex;
        for (int i = 0; i < N - 1; i++) {
            // 初始化最小元素的下标
            lowIndex = i;
            for (int j = i + 1; j < N; j++) {
                // 找出当前数组中最小的元素，记录下标
                if (arr[j] < arr[i]) {
                    lowIndex = j;
                }
                // 将当前数组最小的元素，放在当前数组的最前面位置
                // 交换
                if (i != lowIndex) {
                    int temp = arr[lowIndex];
                    arr[lowIndex] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
