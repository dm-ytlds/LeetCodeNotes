package com.demi.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 归类：字符串
 *  无重复字符的最长子串
 *  解题思路：滑动窗口（双指针）
 *      实现具体：将左指针作为遍历的开始，初始化一个右指针指向数组的头部，怎么样才可以找出不重复的字符呢？可以用到HashSet集合的特性：元素不重复。
 *          所以创建一个HashSet集合，来存储不重复的字符，用HashSet的contains()方法可以找到字符是否已存在。
 *          右指针先向右走，如果在不越界（r < s.length()）的情况下，HashSet中不包含该字符（s.charAt(r)），则将其存入HashSet中，且右指针继续向右走，直到遇到重复元素，
 *          得到此时最长无重复子串的长度r - l。然后左指针向右移动，当左指针不等于0以后，都需要先对HashSet中的字符做一个删除操作（remove(l - 1)），然后继续上述的过程，用Math.max()方法得到最长无重复子串的长度。
 */
public class Q_03_me {
    public static void main(String[] args) {
        String s = "bbbbb";
        int max = lengthOfLongestSubString(s);
        System.out.println(max);
    }

    public static int lengthOfLongestSubString(String s) {
        // 创建一个set集合，统计该字符是否出现过
        Set<Character> sets = new HashSet<>();
        // 定义一个右指针
        int r = 0;
        // 统计不重复字符的个数
        int count = 0;
        // 不需要将字符串转换成字符数组
        // 可以用s.charAt()获取字符串中的字符
        //char[] chars = s.toCharArray();
        int len = s.length();
        for (int l = 0; l < len; l++) {

            if (l != 0) {
                // l为左指针，当左指针不为0之后，每循环一遍，左指针右移1，删除前一个字符
                sets.remove(s.charAt(l - 1));
            }
            while (r < len && !sets.contains(s.charAt(r))) {
                // 不越界且集合中不包含该数组元素
                // 放入集合中，count++
                sets.add(s.charAt(r));
                r++;
            }
            count = Math.max(count, r - l);
        }
        return count;
    }
}
