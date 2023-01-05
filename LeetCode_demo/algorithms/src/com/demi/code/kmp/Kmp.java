package com.demi.code.kmp;

public class Kmp {
    /*
        前缀表如何查找
        如何用前缀表取匹配字符串
     */

    /**
     * 求模式串的前缀表next
     * @param next 前缀表
     * @param s 模式字符串
     */
    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = j;
        char[] chars = s.toCharArray();
        // i是后缀结束为止 j 是前缀结束为止
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];  // 两字符不相等，向前回溯
            }
            if (chars[i] == chars[j]) j++;  // 找到相同的前后缀，最长相等前后缀长度+1
            next[i] = j; // 更新next数组  不管前后缀是否相同，都要将j的值赋给i对应的next数组
        }
    }
}
