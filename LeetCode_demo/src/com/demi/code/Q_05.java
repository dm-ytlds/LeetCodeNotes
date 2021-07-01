package com.demi.code;

import java.util.HashMap;
import java.util.Map;


public class Q_05 {
    public static void main(String[] args) {
        String s = "acbcabb";
        Q_05 qus = new Q_05();
        String subs = qus.longestPalindrome01(s);
        System.out.println(subs);
    }

    /**
     * 1.暴力枚举
     * 时间复杂度：O(n^3). 这里的n是字符串的长度
     * 空间复杂度：O(1).只使用到常数个变量
     * @param s  给定字符串
     * @return   最长回文字符串
     */
    public String longestPalindrome01(String s) {
        int len = s.length();
        // 如果字符串的长度小于2。回文字符串就是本身
        if(len < 2) {
            return s;
        }

        int maxLen = 1;
        int start = 0;

        char[] charsArrays = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if((j - i + 1) > maxLen && isRight(charsArrays, i, j)) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    private boolean isRight(char[] charsArrays, int left, int right) {
        while(left < right) {
            if(charsArrays[left] != charsArrays[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 2.中心扩散法
     * 时间复杂度：O(n^2) [+O(2n - 1)]
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public String longestPalindrome02(String s) {
        int len = s.length();
        // 如果字符串的长度小于2。回文字符串就是本身
        if (len < 2) {
            return s;
        }
        // 最长子串的长度至少为1
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int oddLen = Palindrome(chars, i, i);
            int evenLen = Palindrome(chars, i, i + 1);
            int currLen = Math.max(oddLen, evenLen);
            if(currLen > maxLen) {
                maxLen = currLen;
                begin = i - (len - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @param charsA  字符串字符集
     * @param left    左指针
     * @param right   右指针
     * @return   返回当前最长子串的长度
     */
    private int Palindrome(char[] charsA, int left, int right) {
        int len = charsA.length;
        int i = left;
        int j = right;
        while(i >= 0 && j < len) {
            if(charsA[i] == charsA[j]) {
                i--;
                j++;
            }else {
                break;
            }
        }
        // 跳出while语句时，恰好满足charA[i] != charA[j]
        // 回文长度为：j - (i - 1) - 2 = j - i - 1
        return j - i - 1;
    }
}