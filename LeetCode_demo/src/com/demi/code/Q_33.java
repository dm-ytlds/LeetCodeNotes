package com.demi.code;

/**
 * 归类：数组
 * 题目：搜索旋转数组
 * 注意：有序或者部分有序数组搜索，常考虑二分查找法。
 */
public class Q_33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 3));
    }

    /**
     * 虽然数组有旋转，但旋转前后，局部还是有序数组。
     * 所以仍然可以用二分查找，来让时间复杂度降到O(logN)。
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        // 二分
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) {
            if (nums[0] == target)
                return 0;
            return -1;
        }
        // 注意：用while循环，而不是for
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            // 若相等
            if (nums[mid] == target)
                return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[n - 1])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
