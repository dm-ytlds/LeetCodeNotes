package com.demi.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：组合总和
 * 要求：给定一个无重复元素的中整数数组candidates和一个正整数target，
 *      找出candidates中所有可以是数字和为目标数target的唯一组合。
 *      candidates中的数字可以无限制重复选取，
 *      如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 示例1：
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 *
 * 示例2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 示例3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 * 示例4：
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 *
 */
public class Q_39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * 搜索回溯法
     * @param candidates
     * @param target
     * @return
     */
    // 将组合列表放在方法外面，不用放进回溯方法体内就可以使用，更方便
    static List<List<Integer>> combs;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 存储可能的组合
        combs = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        // 回溯函数
        dfs(candidates, target, comb, 0);
        return combs;
    }

    /**
     *
     * @param candidates    候选数组
     * @param remain    离目标值还差多少
     * @param path      每一个组合
     * @param start         数组下标
     */
    private static void dfs(int[] candidates, int remain, List<Integer> path, int start) {
        // 枚举完整个数组
        if (start == candidates.length)
            return;
        // 或者目标值为0
        if (remain == 0) {
            // 将comb加入combs中
            combs.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 数组元素大于剩下的数值
            if (candidates[i] > remain) return;
            // 如果有相同的数字，直接跳过。（剪枝操作）
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            path.add(candidates[i]);
            dfs(candidates, remain - candidates[i], path, i);
            path.remove(path.size() - 1);
        }

    }
}
