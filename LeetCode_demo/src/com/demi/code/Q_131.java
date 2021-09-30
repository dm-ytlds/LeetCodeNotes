package com.demi.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 题目：分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *  输入：s = "aab"
 *  输出：[["a","a","b"],["aa","b"]]
 *
 *
 */
public class Q_131 {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        System.out.println(res);
    }

    static List<List<String>> res = new ArrayList<>();
    static List<String> path = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        backTracking(s, 0);
        return res;
    }

    // 回溯
    private static void backTracking(String s, int start) {
        // 回溯的终止条件：遍历到字符串尾部，即遍历完整个字符串为止
        if(start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 单层递归条件
        for (int i = start; i < s.length(); i++) {
            // 判断子串是否为回文子串
            if (isOk(s, start, i)) {
                path.add(s.substring(start, i + 1));
            } else continue;
            backTracking(s, i + 1);
            // 回溯
            path.remove(path.size() - 1);
        }
    }

    private static boolean isOk(String s, int start, int end) {
        // 双指针
        int i, j;
        for (i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

}
