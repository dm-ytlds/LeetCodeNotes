package com.demi.code;

/**
 * 归类：字符串
 * 题目：最长回文子串
 * 解题方法：双指针
 */
public class Q_05_me {
    public static void main(String[] args) {
        String s = "babad";
        String sub = LongestCallBackSubstring(s);
        System.out.println(sub);
    }

    public static String LongestCallBackSubstring(String s) {
        // 将字符串转换成字符数组，因为后面要用到字符的遍历
        char[] charsArray = s.toCharArray();
        // 存储最大子串的长度
        int maxLen = 1;
        // 回文子串开始的位置
        int start = 0;
        // 字符串的长度
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 双指针用双循环实现。内存遍历的开始，是外层遍历 + 1
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((j - i + 1) > maxLen && isRight(charsArray, i, j)) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * isRight 方法是用来判断是否是回文串的。
     * @param charsArray
     * @param i
     * @param j
     * @return
     */
    private static boolean isRight(char[] charsArray, int i, int j) {
        while (i < j) {
            // 如果字符串对应的首位字符不相等，必不可能是回文串
            if (charsArray[i] != charsArray[j]) {
                return false;
            }
            // 否则移动指针，继续判断
            i++;
            j--;
        }
        // 直到左右指针相等（左不可能大于右），还是相等字符，则是回文串
        return true;
    }
}
