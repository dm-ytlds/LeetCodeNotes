package com.demi.code;

import com.demi.code.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 归类：数组
 * 题目：括号生成
 */
public class Q_22_me {
    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateBracket(n);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * 一个左括号必然对应一个右括号。
     * 观察发现：开括号的个数必然小于等于n;
     *         闭括号的个数必然等于开括号。
     * @param n
     * @return
     */
    public static List<String> generateBracket(int n) {
        // 存储所有的可能
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        // 用深度优先遍历dfs查找符合条件的括号对
        dfs(n, "", res, 0, 0);
        return res;
    }

    /**
     * 1. 先构建完全二叉树，找出所有的括号组合(这一步不需要在程序中实现，深度优先遍历的时候会自动实现构树的过程。)
     * 2. 从完全树中找出符合条件的括号对。
     *      开括号和闭括号的个数必然小于等于n;
     *      闭括号的个数必然等于开括号。
     * @param n
     * @param path  每一次dfs寻得的路径
     * @param res   最终的括号对结果集
     * @param open  开括号的数量
     * @param close 闭括号的数量
     */
    private static void dfs(int n, String path, List<String> res, int open, int close) {
        // 存储path的条件
        // 如果不符合条件
        if (open > n || close > open) return;
        // 只存储符合条件的括号对
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        dfs(n, path + "(", res, open + 1, close);
        dfs(n, path + ")", res, open, close + 1);
    }
}
