package com.demi.code.tencent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：多数元素
 * 给定一个大小为n的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n / 2 (向下取整)的元素。
 */

public class Q_169 {
    public static void main(String[] args) {
        int[] nums = {6,5,5};
        System.out.println(majorityElement01(nums));
        // System.out.println(singleNumber(nums));
    }

    private static int majorityElement02(int[] nums) {
        // 原地交换
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int singleNumber(int[] nums) {
         int res = 0;
         for (int i = 0; i < nums.length; i++) {
             res ^= nums[i];
         }
         return res;
    }

    /**
     * 首先想到使用map集合以键值对的形式存储元素以及个数.
     *  先找出每个元素出现的次数
     * @param nums
     * @return
     */
    public static int majorityElement01(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        // 找出最大的value值，以及对应的k
        int max = Integer.MIN_VALUE;
        int k = -1;
        for (int key : count.keySet()) {
            if (count.get(key) > max) {
                max = count.get(key);
                k = key;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == k && max > Math.ceil(n / 2)) {
                return k;
            }
        }
        return -1;
    }
}
