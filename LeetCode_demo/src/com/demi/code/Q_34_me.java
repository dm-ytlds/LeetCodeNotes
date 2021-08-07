package com.demi.code;

import java.util.Arrays;

/**
 * 归类：数组，二分法
 * 题目：在排序数组中查找给定元素的第一个和最后一个位置
 * 要求：时间复杂度O(logN)。
 */
public class Q_34_me {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    /**
     * 整体思路：因为是有序数组，所以相等的元素必然在一起。所以可以按以下的方式来找位置。
     *         (1) 找到第一个等于target的元素位置a；
     *         (2) 找到第一个大于target的元素位置b。
     *         第一个位置为a，最后一个位置为b - 1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        // 空数组
        if (n == 0) return new int[] {-1, -1};
        // 找到第一个等于target的元素位置a
        int a = binSearch(nums, target, true);
        // 找到第一个大于target的元素位置b
        int b = binSearch(nums, target, false) - 1;
        // 判断是否满足条件
        if (a <= b && b < nums.length && nums[a] == target && nums[b] == target) {
            return new int[] {a, b};
        }
        return new int[] {-1, -1};
    }

    /**
     * 二分法实现时间复杂度为O(logN)
     * @param nums      有序数组
     * @param target    目标值
     * @param isEqual         true:等于目标值; false:大于目标值
     * @return
     */
    private static int binSearch(int[] nums, int target, boolean isEqual) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target || isEqual && nums[mid] >= target) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
