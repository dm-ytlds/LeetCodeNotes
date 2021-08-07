package com.demi.code;

/**
 * 归类：字符串
 * 题目：删除字符串中重复的字符。
 */
public class Q_26_change01 {
    public static void main(String[] args) {
        String s = "aabbcddddeeeee";
        String res = delDuplicateChar(s);
        System.out.println(res);
    }

    public static String delDuplicateChar(String s) {
        int n = s.length();
        if (n < 2) return s;
        int slow = 0;
        int fast = 1;
        char[] chars = s.toCharArray();
        while (fast < n) {
            if (chars[fast] != chars[fast - 1]) {
                slow++;
                chars[slow] = chars[fast];
            }
            fast++;
        }
        return String.valueOf(chars).substring(0, slow + 1);
    }
}
