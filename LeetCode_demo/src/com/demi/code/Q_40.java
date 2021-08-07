package com.demi.code;

import java.util.*;

public class Q_40 {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    /**
     *
     * @param candidates
     * @param len
     * @param begin 从候选数组的begin位置开始搜索
     * @param remain    表示剩余值
     * @param path  从根节点到叶子节点的路径
     * @param res
     */
    private static void dfs(int[] candidates, int len, int begin, int remain, Deque<Integer> path, List<List<Integer>> res) {
        // 找到满足条件的数组，添加到结果集中，并返回进入下一次回溯
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 排序后的节点，如果出现候选值比剩余值还大的话，后面所有的元素都一定比剩余值大，所以直接break跳出循环
            if (remain < candidates[i]) {
                break;
            }

            // 同一层相同数值的节点结果一定会发生重复，所以continue进入下一次循环
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);

            // 调试语句 ①
            System.out.println("递归之前 => " + path + "，剩余 = " + (remain - candidates[i]));

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, remain - candidates[i], path, res);
            // 调试语句 ②
            System.out.println("递归之后 => " + path + "，剩余 = " + (remain - candidates[i]));

            path.removeLast();
        }
    }
}
