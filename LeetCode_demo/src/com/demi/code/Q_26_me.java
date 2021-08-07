package com.demi.code;

/**
 * 归类：数组
 * 题目：删除有序数组中的重复项
 * 要求：给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素只出现一次 ，
 * 返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 总结：在原地做什么。最好是用指针来完成，考虑从双指针起步。
 */
public class Q_26_me {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 5, 5};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 双指针实现：后指针判断是否和前指针的元素值一样，一样就只移动后指针。
     * 当数组 nums 的长度大于 0 时，数组中至少包含一个元素，
     * 在删除重复元素之后也至少剩下一个元素，因此 nums[0] 保持原状即可，
     * 从下标 1 开始删除重复元素。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }
        // 当数组 nums 的长度大于 0 时，数组中至少包含一个元素，
        int left = 1;
        int right = 1;

        /**
         * 用++left和++right的好处：
         *  防止左指针比右指针走的还快。所以先将右指针前进一步。实现了快慢指针的双指针操作。
         */
        while (right < n) {
            if (nums[right] != nums[right - 1]) {
                // 不等，先将左指针右移，再将右指针指向的值赋给左指针指向的位置
                nums[++left] = nums[right];
            }
            ++right;
        }


        return left;
    }
}
