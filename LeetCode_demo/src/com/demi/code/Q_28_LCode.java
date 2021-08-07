package com.demi.code;

public class Q_28_LCode {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "iss";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int index = -1;
        // 计算子串的模式匹配表
        int[] next = new int[m];
        for (int i = 0, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        // 匹配子串在主串中的起始位置index
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = next[j - 1];
            if (haystack.charAt(i) == needle.charAt(j))
                j++;
            if (j == m)
                index = i - m + 1;
        }
        return index;
    }
}
