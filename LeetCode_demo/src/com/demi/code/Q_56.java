package com.demi.code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *  输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 *  输出: [[1,6],[8,10],[15,18]]
 *  解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class Q_56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] res = merge(intervals);
        System.out.println(Arrays.deepToString(res));
    }

    /**
     * 先找出每个区间的首末元素值。一个区间就是一行。
     *  有重复区间的情况：intervals[i][0] < intervals[i - 1][1]
     * 知识点整理：
     *  Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));  intervals为二维数组，这种写法是按照二维数组的第0列升序排列。
     *  Arrays.sort(nums, (o1, o2) -> (o2, 01));   nums为一维数组，该方法是指定排序的规则为反向排序。
     *      sort本身是从小到大排序，这样写的话，就实现了从大到小的排序方式。
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        // 收集结果区间列表
        List<int[]> res = new ArrayList<>();
        // 给二维数组排序，按照区间的左端点来排序，从矩阵的形式来看，就是按照第0列排序
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        // System.out.println(Arrays.deepToString(intervals));
        // 初始化开始端点，从第0行0列元素开始
        int start = intervals[0][0];
        // 按二维数组的行进行遍历
        for (int i = 1; i < intervals.length; i++) {
            // intervals[i][0] > intervals[i - 1][1]，说明这两个区间没有重复区间，保留该开始区间为单独的区间
            if (intervals[i][0] > intervals[i - 1][1]) {
                // 保留该开始区间为单独的区间
                res.add(new int[] {start, intervals[i - 1][1]});
                // 继续下一个区间（即下一行）
                start = intervals[i][0];
            } else {
                // 有重复区间的情况，将两个区间中第1列较大值返回给该列作为新的右端点值
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }
        // 可合并的合并完后，保留最终合并区间
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        // 将列表转换成二维数组返回
        return res.toArray(new int[res.size()][]);
    }
}
