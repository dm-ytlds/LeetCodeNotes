package com.demi.code;

import java.util.Arrays;

/**
 * 题目：最后一个单词的长度
 */
public class Q_58 {
    public static void main(String[] args) {
        String s = "Hello World";
//        String trim = s.trim();
//        System.out.println(Arrays.toString(trim.toCharArray()));
        System.out.println(lengthOfLastWord01(s));
    }

    private static int lengthOfLastWord02(String s) {

        int end = s.length() - 1;
        // 从后往前，找到第一个不为空字符的位置，记录下来
        while (end >= 0 && s.charAt(end) == ' ') end--;
        // 可能为一个空串字符串的情况
        if (end < 0) return 0;
        // 从后往前接着找，找到第一个为空的字符位置，记录下来
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        // 两位置相减即为所求最后一个单词的长度
        return end - start;
    }

    /**
     * 引用了自带的除去首位空白字符的函数
     * @param s
     * @return
     */
    public static int lengthOfLastWord01(String s) {
        s = s.trim();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count += 1;
            } else
                break;
        }
        return count;
    }
}
