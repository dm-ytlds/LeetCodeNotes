package com.algorithms;

/** 范围式模型
 * 题目要求：给定一个数字数组，有A，B两人，每次只能有一个人从数组两端的任意一端取出一个数，最终数字取完，获得数字之和值 更大 的人获胜。
 * 示例：
 *  int[] arr = [1, 100, 3, 7]
 */
public class demo05 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 100, 3, 6};
        int winnerScore = win(arr);
        System.out.println(winnerScore);
    }

    public static int win(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    // 先手函数。即每一次做选择，先选数字的人
    public static int first(int[] arr, int L, int R) {
        // 如果数组中只有一个数字，那么一个人就拿完
        if (L == R) {
            return arr[L];
        }
        return Math.max(arr[L] + second(arr, L + 1, R), arr[R] + second(arr, L, R - 1));
    }
    // 后手函数。主要目的是对后选的人有利。所以在返回值时，尽量挑选较小的值留给先手，从而让自己获得更大的数字总和。
    private static int second(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        return Math.min(first(arr, l + 1, r), first(arr, l, r - 1));
    }
}
