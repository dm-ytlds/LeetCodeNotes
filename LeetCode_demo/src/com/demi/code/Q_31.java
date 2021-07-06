package com.demi.code;


import java.util.Arrays;

/** 题目：下一个排列
 *  题目描述：实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序列中下一个更大的排列。
 *          如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 *  必须 原地 修改，只允许额外的常熟空间。
 *
 *  示例 1：
 *      输入：nums = [1,2,3]
 *      输出：[1,3,2]
 *
 *  示例 2：
 *      输入：nums = [3,2,1]
 *      输出：[1,2,3]
 *
 *  示例 3：
 *      输入：nums = [1,1,5]
 *      输出：[1,5,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 */
public class Q_31 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 5};
        Q_31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     *  下一个排列
     *  我们希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。具体地：
     *      1.我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
     *      2.同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
     *      这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
     *  具体地，我们这样描述该算法，对于长度为 n 的排列 a：
         * 首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i] < a[i+1]。
     *      这样「较小数」即为 a[i]。此时 [i+1,n) 必然是下降序列。
         * 如果找到了顺序对，那么在区间 [i+1,n)中从后向前查找第一个元素 j 满足 a[i] < a[j]。
     *      这样「较大数」即为 a[j]。
         * 交换 a[i] 与 a[j]，此时可以证明区间 [i+1,n) 必为降序。
     *      我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序，而无需对该区间进行排序。
     * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        // 初始化
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i ,j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
