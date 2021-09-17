package com.demi.code;

/**
 * 题目：有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 */
public class Q_242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaran";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        // 如果字符串长度不同，必不可能是字母异位词
        if (s.length() != t.length()) {
            return false;
        }
        // 如果满足字母异位，那么数组中对应的元素都为0
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
            letters[t.charAt(i) - 'a']--;
        }
        // 遍历数字数组，有不等于0的元素，则不满足
        for (int c : letters) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
