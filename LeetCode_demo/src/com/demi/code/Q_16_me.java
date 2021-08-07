package com.demi.code;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 题目：最接近的三数之和
 *  给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 *  使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class Q_16_me {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(closestThreeSum(nums, target));
    }

    /**
     * 单循环加双指针
     * @param nums
     * @param target
     * @return
     */
    public static int closestThreeSum(int[] nums, int target) {
        // 前面处理和三数之和一样
        int n = nums.length;
        if (nums == null || n < 3) return -1;
        Arrays.sort(nums);
        // 初始化一个最接近的值
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return target;
                if (Math.abs(target -sum) < Math.abs(target - best)) {
                    best = sum;
                    l++;
                    r--;
                }
                if (sum < target) {
                   r--;
                } else {
                    l++;
                }
            }
        }
        return best;
    }
}
