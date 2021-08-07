package com.demi.code;

/**
 * 归类：数组
 * 题目：移除元素
 * 要求：给你一个数组 nums 和一个值 val，
 * 你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Q_27_me {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 3, 3, 4, 4, 5};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    /**
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }
        int s = 0;
        int f = 0;
        while (f < n) {
            if (nums[f] != val) {
                nums[s++] = nums[f];
            }

            f++;
        }
        return s;
    }
}
