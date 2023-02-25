package com.demi.strings;

import java.util.Scanner;

public class HJ32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            // 输入的密码串
            String passwd = in.nextLine();
            System.out.println(matchMaxSubString(passwd));
        }
    }

    private static int matchMaxSubString(String s) {
        int n = s.length();
        if (n < 1 || s == null) return 0;
        // 1. 确定dp数组及下标的含义
        // 二维dp数组 [i~j] 表示子串从i到j dp[i][j]表示从i到j是否是回文子串
        boolean[][] dp = new boolean[n][n];
        // 2. 初始化dp数组 对角线处对应的是同一个字符，所以必是回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 字符串长度大于等于1才会有子串，所以将最长回文子串的最大长度初始化为1
        int maxLen = 1;
        // 3. 确定遍历顺序 最小从长度为2开始进入循环体
        for (int len = 2; len <= n; len++) { // 子串的长度
            for (int lBound = 0; lBound < n; lBound++) {  // 从字符串的最左边开始遍历 左边界
                // 确定当前子串的右边界
                int rBound = len + lBound - 1;  // len = rBound - i + 1
                if (rBound >= n) {
                    break;
                }
                if (s.charAt(lBound) != s.charAt(rBound)) {
                    dp[lBound][rBound] = false;
                } else {
                    // 首尾两个字符相同有两种情况：（1）两字符是同一个字符，长度为1；（2）两字符为两个相同的字符，长度为2，所以需要长度小于3
                    if (rBound - lBound < 3) {
                        dp[lBound][rBound] = true;
                    } else {
                        dp[lBound][rBound] = dp[lBound + 1][rBound - 1];
                    }
                }
                // 确定当前子串是否是回文子串  是的话求出当前最大长度
                if (dp[lBound][rBound] && rBound - lBound + 1 > maxLen) {
                    maxLen = rBound - lBound + 1;
                }
            }
        }
        return maxLen;
    }
}
