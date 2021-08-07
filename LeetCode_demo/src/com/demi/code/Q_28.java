package com.demi.code;

/** 题目：实现strStr()
 *  题目描述：实现strStr()函数。
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 */
public class Q_28 {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }


    /**
     *  模式匹配
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) {
            return 0;
        }
        int index = -1;

        // int[] next = getNext(needle);

        int[] next = new int[n];
        next[0] = -1;
        if (n > 1) {
            int i = 0, k = 0;
            next[1] = 0;
            while (i < n - 1) {
                if (needle.charAt(i) == needle.charAt(k)) {
                    next[i + 1] = k + 1;
                    i++;
                    k++;
                } else if (k == 0) {
                    i++;
                } else {
                    k = next[k];
                }
            }
        }

        // 枚举主串和子串的字符
        int a = 0, b = 0;
        while (a < m && b < n) {
            if (haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            } else if (b == 0) {
                a++;
            } else {
                b = next[b];
            }
        }
        if (b == n) {
            index = a - n;
        }
        return index;
    }

//    private static int[] getNext(String needle) {
//        int i = 0, k = 0;
//        int n = needle.length();
//        int[] next = new int[n];
//        next[0] = -1;
//        next[1] = 0;
//        while (i < n - 1) {
//            if (needle.charAt(i) == needle.charAt(k)) {
//                next[i + 1] = k + 1;
//                i++;
//                k++;
//            } else if (k == 0) {
//                i++;
//            } else {
//                k = next[k];
//            }
//        }
//        return next;
//    }
}
