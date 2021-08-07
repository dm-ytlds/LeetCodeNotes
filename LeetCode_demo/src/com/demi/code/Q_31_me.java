package com.demi.code;

import java.util.Arrays;

/**
 * 归类：数组
 * 题目：下一个排列
 * 要求：实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典中下一更大的排列。
 *  如果不存在下一个更大的排列，则将数字重新排列成最小的排列（最小的排列就是升序排列）。
 *  必须原地修改，只允许使用额外的常数空间。
 */
public class Q_31_me {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 5, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Permutation：排列(方式); 组合(方式); 置换。
     * 由于是原地修改，所以返回的void。
     * 整体的思路：
     *    (1) 先从后(倒数第2个数 i ，因为倒数第1个数已经是当前的最后一个数字了，比较无意义。)往前，
     *        比较第i个数和第i + 1个数，找到第一个nums[i] < nums[i + 1]的数；
     *    (2) 根据第(1)步得到的第i个数，重新从后(倒数第1个数 j 起)往前，找到第一个nums[i] < nums[j]的数为止；
     *    (3) 交换nums[i]与nums[j]的位置；
     *    (4) 交换位置后，从第 i + 1个数开始，将数组后面的数排序。
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 不越界
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        sort(nums, i + 1);


    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void sort(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
