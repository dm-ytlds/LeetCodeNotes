package com.demi.code.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：子集
 * 给你一个整数数组nums,数组中的元素互不相同。返回该数组所有可能的子集(幂集)。
 * 解集不能包含重复的子集。
 *
 */
public class Q_78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(subsets02(nums).toArray()));
    }

    /**
     *
     */
    static List<List<Integer>> res = new ArrayList<>();  // 存放符合条件结果的集合
    static List<Integer> path = new ArrayList<>();   // 用来存放符合条件结果
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        backTracking(nums, 0, n);
        return res;
    }

    private static void backTracking(int[] nums, int index, int n) {
        // 如果数组遍历到结尾，那么遍历结束，递归终止。
        if (index >= n) {
            res.add(new ArrayList<>(path));
            return;
        }

        /*
        * 接下来是单层搜索逻辑。
        * 对于子集问题，不需要任何的剪枝操作，因为子集问题就是要遍历整棵树
        * */
        // 选择当前位置的元素
        path.add((nums[index])); // 子集收集元素
        backTracking(nums, index + 1, n);
        // 回溯
        path.remove(path.size() - 1);
        // 不选择当前位置的元素
        backTracking(nums, index + 1, n);

    }

    /**
     * 该方法使用的是回溯算法。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets02(int[] nums) {
        if (nums.length == 0){
            res.add(new ArrayList<>());
            return res;
        }
        subsetsHelper(nums, 0);
        return res;
    }

    /**
     * 回溯的实现。单次搜索的逻辑：从开始递归的位置开始遍历，因为对于子集来说：{1, 2}和{2, 1}是一样的，
     *  在遍历完一次后，需要收集的是该条路径上所有节点保存的集合。
     * @param nums
     * @param startIndex
     */
    private static void subsetsHelper(int[] nums, int startIndex){
        res.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }
        /**
         * 单次搜索的逻辑，即简单的递归
         */
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            // 最后别忘了回溯。
            path.remove(path.size() - 1);
        }
    }
}
