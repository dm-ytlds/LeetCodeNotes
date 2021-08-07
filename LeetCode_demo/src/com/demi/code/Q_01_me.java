package com.demi.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 归类：数组
 * 两数求和
 *
 */
public class Q_01_me {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
        // HashMap集合求解
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numbers.containsKey(target - nums[i])) {
                numbers.put(nums[i], i);
            } else {
                return new int[]{i, numbers.get(target - nums[i])};
            }
        }
        return new int[]{-1};
    }
}
