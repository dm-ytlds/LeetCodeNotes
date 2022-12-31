package com.demi.code;

import java.util.HashMap;
import java.util.Map;

public class Q_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        /*
            前两个数组元素对应相加，将和与个数存入map中
            后两个数组元素相加，将两数之和与个数存入map中
            在遍历两个map两两相加，计数和为0的元素个数
        */
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i : nums1) {
            for(int j : nums2) {
                int k = i + j;
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }
        int[] sum = new int[nums3.length];

        for(int i : nums3) {
            for(int j : nums4) {
                int target = 0 - (i + j);
                if(map.containsKey(target)) {
                    count += map.get(target);
                }
            }
        }
        return count;
    }
}
