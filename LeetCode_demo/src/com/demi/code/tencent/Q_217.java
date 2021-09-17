package com.demi.code.tencent;

import java.util.HashSet;
import java.util.Set;

public class Q_217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Solution s = new Solution();
        boolean b = s.containsDuplicate(nums);
        System.out.println(b);
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2 || nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}