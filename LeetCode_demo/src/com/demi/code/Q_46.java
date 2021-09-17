package com.demi.code;

import java.util.*;

/**
 * 题目：全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Q_46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute02(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }


    public static List<List<Integer>> permute01(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        int n = nums.length;
        // 将数组中的数字先放在列表中
        for (int i = 0; i < n; i++) {
            out.add(nums[i]);
        }
        backTracking01(n, out, res, 0);
        return res;
    }

    /**
     * Method02。较Method01易于理解
     */
    static List<List<Integer>> res = new ArrayList<>();    // 存放符合条件的结果集合
    static LinkedList<Integer> path = new LinkedList<>();  // 用来存放符合条件的结果
    static boolean[] used;
    private static List<List<Integer>> permute02(int[] nums) {
        // 如果数组长度为0，直接输出空集合
        if (nums.length == 0) {
            return res;
        }
        // 创建数组数字是否已被使用的bool数组。默认都是false
        // 确保每个元素只在一个列表中使用一次
        used = new boolean[nums.length];
        // System.out.println(Arrays.toString(used));
        // 创建递归函数
        permuteHelper(nums);
        return res;
    }

    /**
     * Method02中回溯的操作方式：
     *  如果路径长度达到了原数组的长度，就添加到总集合中，并进入return下一次递归。
     *  如果不满足，即path.size < nums.length，循环遍历整个数组：
     *      首先判断这个数组元素是否已经被使用过了，被使用过，就继续下一次循环；
     *      如果没被使用过，首先将该元素设置为被使用过，然后将该元素添加到path集合中，接着继续递归整个数组，然后将path的最后一个元素移除，并重新置该元素未被使用过false（因为1,2和2,1是不同的排列）。
     *
     * ****定义多余的变量会耗内存以及消耗执行时间，尽量不去定义多余的变量****。
     * @param nums
     */
    private static void permuteHelper(int[] nums) {
        // 如果路径长度达到了原数组的长度，就添加到总集合中，并return进入下一次递归。
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            // 递归到叶子节点为止
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }

    /**
     * Method01
     * 典型的回溯算法求解
     * @param n 数组长度
     * @param out   满足排列的列表
     * @param res   全排列列表
     * @param first 第一个元素
     */
    private static void backTracking01(int n, List<Integer> out, List<List<Integer>> res, int first) {
        // 如果所有数字都找到了
        if (first == n) {
            res.add(new ArrayList<>(out));
        }

        for (int i = first; i < n; i++) {
            // 交换out列表的out[startIndex]和out[i]两个数字
            Collections.swap(out, first, i);
            // 下一次递归
            backTracking01(n, out, res, first + 1);
            // 撤销动态维护数组
            Collections.swap(out, first, i);
        }
    }


}
