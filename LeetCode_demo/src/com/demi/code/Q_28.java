package com.demi.code;

/** 题目：实现strStr()
 *  题目描述：实现strStr()函数。
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 */
public class Q_28 {
    public static void main(String[] args) {

    }


    /**
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        /*for (int i = 0; i < haystack.length(); i++) {
            haystack.indexOf(i);
        }*/
        return haystack.indexOf(needle);
    }
}
