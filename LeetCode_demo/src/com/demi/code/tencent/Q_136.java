package com.demi.code.tencent;

import java.util.Arrays;

/**
 * 题目：只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。展出哪个只出现一次的元素。
 * 说明：
 *  应该具有线性时间复杂度。不使用额外的空间来实现。
 */
public class Q_136 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    /**
     * 如何才能做到线性时间复杂度和常数空间复杂度呢？
     *
     * 答案是使用位运算。对于这道题，可使用异或运算 ⊕。异或运算有以下三个性质。
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int num : nums) {
            i ^= num;
        }
        return i;
    }
}
