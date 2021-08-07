package com.demi.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 归类：数组
 * 题目：三数之和
 */
public class Q_15_me {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lis = threeSum(nums);
        for (List<Integer> li : lis) {
            System.out.println(li);
        }

    }

    /**
     * 题目要求：
     *  给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
     *  使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 双指针，加单循环
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        // 存放三元组
        List<List<Integer>> lists = new ArrayList<>();
        // 单循环套在最外面
        for (int k = 0; k < n; k++) {
            // 先排除所有数字大于0的情况
            if (nums[k] > 0) break;
            // 排除紧挨着的相同数字，因为要求是三元组不重复
            if (k + 1 <= n && nums[k] == nums[k + 1]) continue;
            // 双指针的设置
            int i = k + 1, j = n - 1;
            while (i < j) {
                //  求三数之和
                int sum = nums[k] + nums[i] + nums[j];
                // 三数之和
                if (sum > 0) {
                    i++;
                } else if (sum < 0) {
                    j--;
                } else {
                    lists.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    // 然后移动左右指针
                    while (nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (nums[j] == nums[j - 1]) {
                        j--;
                    }
                }
            }
        }
        return lists;
    }
}
