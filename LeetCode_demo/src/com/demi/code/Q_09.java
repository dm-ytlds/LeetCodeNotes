package com.demi.code;

/**
 * 题目要求：
 *  给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *  回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 *
 */
public class Q_09 {
    public static void main(String[] args) {
        Q_09 qus = new Q_09();
        int x = -121;
        boolean b = qus.isPalindrome02(x);
        System.out.println(b);
    }

    /**
     * 方法1
     * 解题思路：
     *  先将输入的数字转换成字符数组，然后将字符数组翻转，判断翻转后的字符数组是否和原数组相等。
     * @param x
     * @return
     */
    public boolean isPalindrome01(int x) {
        char[] charsArray = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = charsArray.length;
        for (int i = len-1; i >= 0; i--) {
            sb.append(charsArray[i]);
        }
        String newx = sb.toString();
        return String.valueOf(x).equals(newx) ? true : false;
    }

    /**
     * 方法2
     * 解题思路：
     * 如果为负整数，直接返回false；如果为正整数，则直接将整数翻转，再与原数字作比较。
     * @param x
     * @return
     */
    public boolean isPalindrome02(int x) {
        if(x < 0) {
            return false;
        }
        int ox = x;
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            res = res * 10 + temp;
            x = x / 10;
        }
        return ox == res ? true : false;
    }
}
