package com.demi.code.sorts;

import java.util.Arrays;

/**
 * 基数排序的实现
 * 基数排序采用最低优先的方式，将所有待排序数列元素统一为同样的数位长度，数列元素数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {1234, 345, 657, 435, 589, 900};
        // 计算数组中最大元素的位数
        // 先找出最大的元素
        int max = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // 然后计算出最大元素的位数
        int maxLength = String.valueOf(max).length();
        int[] result = radixSort(arr, maxLength);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 基数排序的实现代码
     * https://www.bilibili.com/video/BV184411L79P?from=search&seid=5431776783583763309
     * @param arr
     * @param maxLength
     * @return
     */
    public static int[] radixSort(int[] arr, int maxLength) {
        int[] result = new int[arr.length];
        int[] count = new int[10];  // 存储元素的位数对应的值
        for (int i = 0; i < maxLength; i++) {
            // pow() 方法用于返回第一个参数的第二个参数次方。
            int division = (int)Math.pow(10, i);
            System.out.println(division);
            // 对数组中的每个数，从个位数开始进行排序
            for (int j = 0; j < arr.length; j++) {
                /* 例如数字 421
                    第一次的division为1，所以421 / division的结果为421
                    对421 % 10的结果为1，即得到了421的个位数值1
                 */
                int num = arr[j] / division % 10;
                System.out.println(num + " ");
                count[num]++;
            }
            System.out.println();
            System.out.println(Arrays.toString(count));

            // 意义何在？
            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m - 1];
            }
            System.out.println(Arrays.toString(count));

            // 没看懂
            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / division % 10;
                result[--count[num]] = arr[n];
            }
            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);

        }
        return result;
    }
}
