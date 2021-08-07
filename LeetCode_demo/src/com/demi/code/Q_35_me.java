package com.demi.code;

/**
 * 归类：数组
 * 题目：搜索插入位置
 * 要求：给定一个排序数组和一个目标值，在数组中找到目标值，
 *  并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class Q_35_me {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchIndex(nums, target));
    }

    /**
     * 二分法。稍有不同：
     *
     * @param nums
     * @return
     */
    public static int searchIndex(int[] nums, int target) {
        int n = nums.length;
        // 初始化结果
        int res = n;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                // 每次遍历都保存比target值小或者等于target的值
                res = mid;
                right = mid - 1;
            } else {

                left = mid + 1;
            }
        }
        return res;
    }
}
