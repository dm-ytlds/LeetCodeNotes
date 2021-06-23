package com.demi.code;

/** 题目：删除有序数组中的重复项
 *  题目描述：给你一个有序数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 *  不要使用额外的数组空间，你必须在原地修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  示例 1：
 *  输入：nums = [1,1,2]
 *  输出：2, nums = [1,2]
 *  解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 *  示例 2：
 *  输入：nums = [0,0,1,1,1,2,2,3,3,4]
 *  输出：5, nums = [0,1,2,3,4]
 *  解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
public class Q_26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Q_26 qus = new Q_26();
        int n = qus.removeDuplicates(nums);
        System.out.println(n);

    }
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        // 双指针
        int slow = 1, fast = 1;
        // 当快指针的下一个数字和前一个数字相同，则慢指针不移动，否则慢指针和快指针都移动
        while (fast < len) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
