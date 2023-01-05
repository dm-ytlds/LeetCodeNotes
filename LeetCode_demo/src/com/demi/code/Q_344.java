package com.demi.code;

import java.util.Arrays;

/**
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 */
public class Q_344 {
    /*
    * 思路：双指针法
    * 左、右指针指向的元素互换
    * 左、右指针同时向中间移动
    * */
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "get out 2022";
        System.out.println(reverseString(s));
    }
}
