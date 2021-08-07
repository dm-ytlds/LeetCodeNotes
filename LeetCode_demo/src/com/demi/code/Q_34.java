package com.demi.code;

import java.util.Arrays;

public class Q_34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange(nums, 8);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        int leftIndex = binarySearch(nums, target, true);
        // 找出第一个大于目标值的元素
        int rightIndex = binarySearch(nums, target, false) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }

    private static int binarySearch(int[] nums, int target, boolean b) {
        int l = 0;
        int r = nums.length - 1;
        int ans = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target || b && nums[mid] >= target) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
