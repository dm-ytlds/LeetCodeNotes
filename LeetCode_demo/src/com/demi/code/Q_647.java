package com.demi.code;

/**
 * 题目：回文子串的个数
 *
 */

public class Q_647 {
    public static void main(String[] args) {
        String s = "aabc";
        System.out.println(countSubstring(s));
    }

    private static int countSubstring(String s) {
        int n = s.length();
        /* 1.确定dp数组以及下标的含义
            dp[i][j]表示区间[i, j]上子串是否是回文子串。如果dp[i][j] = true，表示是回文子串，否则不是。
           2.确认递推公式
            有三种情况：
            (1) 如果下标i和下标j相同，即同一个字符时，肯定是回文子串；
            (2) 如果下标i和下标j相差为1，例如aa，也是回文字符串；
            (3) 下标i和j相差大于1的情况。例如 cabac，此时s.charAt(i)与s.charAt(j)已经相同了，可以看到i到j区间是不是回文子串，
            需要看aba是否为回文子串就可以了。可以看出，aba的区间为[i + 1, j - 1]，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
            3.默认初始化就为false
         */
        boolean dp[][] = new boolean[n][n];
        // 4.确定遍历顺序
        // 从下往上，从左往右
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 分情况讨论
                    if (j - i <= 1) {
                        // j - i = 1，表示两个元素为中心点的情况
                        // j - i = 0,表示一个元素为中心点的情况
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        //
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        // 5.输出结果
        return res;
    }
}
