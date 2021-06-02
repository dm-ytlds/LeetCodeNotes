package com.demi.code;

/**
 * 题目要求：
 *  给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *  如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 */
public class Q_08 {
    public static void main(String[] args) {
        Q_08 qus = new Q_08();
        int x = -12345;
        int res = qus.reverse(x);
        System.out.println(res);
    }

    /**
     * 解题思路：
     *  无论输入的数字是正数数还是负整数，都可以直接取模，因为取模运算可以包含正负号。***
     *  题目要求返回的有符号位整数不超过整数范围。所以需要提前的一个限制。
     * @param x
     * @return
     */
    public int reverse(int x) {
        // 对输入的数字循环取模
        // 存储结果
        int result = 0;
        // 符号位初始化
//        int sign = 1;
        while(x != 0) {
            int temp = x % 10;
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            result = result * 10 + temp;
            x = x / 10;
        }
        return result;
    }
}