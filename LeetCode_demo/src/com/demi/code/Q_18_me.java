package com.demi.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 归类：数组
 * 题目：四数之和
 * 要求：不可以包含重复的四元组。
 */
public class Q_18_me {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> res = fourSum(nums, target);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        // 数组为空数组
        if (nums == null || n < 4) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        // 先遍历最外层。i < n - 3的原因：用到了i + 3。防止下边越界。
        for (int i = 0; i < n - 3; i++) {
            // 有重复的元素，跳出本次循环，进入下一次循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 前四个值加起来本就大于target，那么就不存在有四个数等于target，直接结束循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 如果i对应的元素，和后三个元素之和小于target，说明还有可能找到等于target的四个元素，进入下次循环
            if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }

            // 第二重循环
            for (int j = i + 1; j < n - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 同样考虑上面两种情况。别忘了i
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if(nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }
                // 双指针，减少一次循环
                int l = j + 1;
                int r = n - 1;
                while (l <= r) {
                    // 四个数都可以表示了，求和
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // 去重
                        while (l < r && nums[l] == nums[l++]);
                        l++;
                        while (l < r && nums[r] == nums[r--]);
                        r--;
                    } else if (sum > target) {
                        // 四数之和比目标值大，需要找更小的数
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
