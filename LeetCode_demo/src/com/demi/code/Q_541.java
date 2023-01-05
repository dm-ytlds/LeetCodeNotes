package com.demi.code;

import java.util.Arrays;

/**
 * 反转字符串 ②
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 */
public class Q_541 {
    public static String reverseString2(String s, int k) {
        char[] chars = s.toCharArray();
        // 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < s.length(); i += 2 * k) {
            // 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if(i + k < s.length()) {
                reverse(chars, i, i + k - 1);
                continue;
            }
            //  剩余字符少于 k 个，则将剩余字符全部反转
            reverse(chars, i, chars.length - 1);
        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int i, int j) {
        // 注意，这里不需要再去定义for循环的初始位置，传过来的 i j 就是元素互换的左、右指针
        for (; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
