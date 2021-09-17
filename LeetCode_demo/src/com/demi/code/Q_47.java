package com.demi.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目： 全排列2
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1： 输入：nums = [1,1,2] 输出： [[1,1,2], [1,2,1], [2,1,1]]
 * 示例 2： 输入：nums = [1,2,3] 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class Q_47 {
    public static void main(String[] args) {
        int[] nums = {3,3,0,3};
        List<List<Integer>> res = premutations(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * 这里和46题的不同之处在于：
     *  传参时需要将元素是否被使用过也传进递归函数去，实现同树枝的相同元素可以重复使用。
     * @param nums
     * @return
     */
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static boolean[] used;
    public static List<List<Integer>> premutations(int[] nums) {
        if (nums.length == 0)
            return res;
        used = new boolean[nums.length];
        // Arrays.fill(used, false);
        // 排序。该方法严重依赖排序，如果未排序，结果千差万别。
        Arrays.sort(nums);
        premuteHelper(nums);
        return res;
    }

    /**
     * 不同之处在于：
     *  对于剪枝操作，最好是放在同一树层， 可以免去很多不必要的操作。
     *  剪枝操作遵循的原理：
     *      同一树枝上的重复数字可以重复使用；
     *      同一树层的重复数字不可重复使用。
     * @param nums
     */
    private static void premuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 剪枝操作。
            // used[i - 1] == true，说明同树枝nums[i - 1]使用过
            // used[i - 1] == false，说明同树层nums[i - 1]使用过
            // 如果同树层nums[i - 1]使用过，则直接跳过(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
            // 或者待遍历的数字已使用过（used[i] == true），直接跳过
            if ((i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) || used[i] == true)
                continue;
            used[i] = true;
            path.add(nums[i]);
            premuteHelper(nums);
            path.remove(path.size() - 1);
            used[i] = false;    // 回溯，实现同一树枝上可以重复使用
        }
    }
}
