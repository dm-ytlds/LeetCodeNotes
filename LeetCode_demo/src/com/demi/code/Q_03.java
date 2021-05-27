package com.demi.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目要求：
 *      给定一个字符串，请找出其中不含有重复字符的最长子串的长度。
 *
 *      示例 1:
 *      输入: s = "abcabcbb"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *      示例 2:
 *      输入: s = ""
 *      输出: 0
 *
 *      解题思路：一旦涉及到次数（计数），就应该想到散列表
 *          设置两个指针，一个指针为左指针，代表枚举子串的起始位置，右指针选择从第k + 1个字符作为起始位置，
 *          首先从k + 1到rk的字符显然是不重复的，并且由于少了原本的第k个字符，可以尝试继续增大rk，直到右侧出现了重复字符为止。
 *          在每一步操作中，我们将左指针向右移动一格，表示我们开始枚举下一个字符作为起始位置，
 *          然后我们可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。
 *          在移动结束后，这个子串就应对着以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度；
 *          在枚举结束后，我们找到的最长的子串的长度即为答案。
 *
 */
public class Q_03 {
    public static void main(String[] args) {
        Q_03 qus = new Q_03();
        String s = "abcabcbb";
        int count = qus.lengthOfLongestSubstring(s);
        System.out.println(count);

    }
    public int lengthOfLongestSubstring(String s) {
        // 记录字符串中每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int len = s.length();
        // 右指针的初始值为-1，相当于我们在字符串的左边界的左侧，还没开始移动
        int rk = -1, count = 0;
        // 循环遍历。从i = 0 遍历到 i = lens - 1 。 每一次都从数组中找出最长的字符串，
        for (int i = 0; i < len; i++) {
            if(i != 0) {
                // i作为左指针，左指针往右移1，去除一个字符
                set.remove(s.charAt(i - 1));
            }
            // 如果右指针不越界且集合set中不包含该字符，右指针一直向右移动
            while(rk + 1 < len && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                ++rk;
            }

            // 计数
            count = Math.max(count, rk - i + 1);
        }
        return count;
    }
}
