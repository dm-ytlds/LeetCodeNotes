package com.demi.code;

import java.util.Arrays;

/**
 * 题目：加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class Q_66 {
    public static void main(String[] args) {
        int[] nums = {9,9,9,9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }

    /**
     * 思路妙蛙。
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0)
                return digits;
        }
        // 上面没返回，就一定存在进位的情况。并且此时digits数组的所有元素都为0。
        // 只需要将digits数组的位数+1，并且令digits[0] = 1，返回即为所求。
        digits = new int[digits.length + 1];
        System.out.println(Arrays.toString(digits));
        digits[0] = 1;
        return digits;
    }
}
