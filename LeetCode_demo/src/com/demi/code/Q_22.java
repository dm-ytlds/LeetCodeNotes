package com.demi.code;

import java.util.ArrayList;
import java.util.List;

/** 题目：括号生成
 *  描述：数字n 代表括号的对数，设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 *
 *  示例 1：
 *      输入：n = 3
 *      输出：["((()))","(()())","(())()","()(())","()()()"]
 *  示例 2：
 *      输入：n = 1
 *      输出：["()"]
 *
 */
public class Q_22 {
    public static void main(String[] args) {
        int n = 3;
        Q_22 qus = new Q_22();
        System.out.println(qus.generateParenthesis(n));
    }


    /**
     * 解题思路：
     *    先根据所给的要生成的括号对数n，列举出所有可能的括号组合；
     *    然后，用 剪枝操作 过滤不符合括号成对要求的括号组合；
     *    用递归方法，找到最终所要的结果。
     *
     * @param n 生成括号的对数
     * @return  有效的括号组合
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;
        dfs(n, "", res, 0, 0);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close) {
        // 删除不满足要求的括号组合（剪枝操作）
        if(open > n || close > open) return;
        // 用完全树的结构来理解，找出所有可能的不管满足结果与否的组合
        if(path.length() == 2 * n) {
            res.add(path);
            return;
        }
        dfs(n, path + "(", res, open + 1, close);
        dfs(n, path + ")", res, open, close + 1);
    }
}
