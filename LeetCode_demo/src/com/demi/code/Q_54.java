package com.demi.code;

import java.util.*;

/**
 * 题目：螺旋矩阵
 * 将矩阵中的数字按顺时针的顺序输出所有的元素。
 */
public class Q_54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> ans = spiralOrder(matrix);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    /**
     * 按层模拟
     *  思想：将矩阵看成若干层，首先输出最外层的元素，其次输出次外层的元素，直到输出最内层元素为止。
     *  做法：
     *      对于每层，从左上开始以顺时针的顺序遍历所有元素，假设当前层的左上角位于(top, left)，右下角位于(bottom, right)，按照如下顺序遍历当前层的元素：
     *          (1) 从左向右遍历上层元素，依次为(top, left)到(top, right)；
     *          (2) 从上向下遍历右侧元素，依次为(top + 1, left)到(bottom, right)；
     *      如果left < right 且 top < bottom：
     *          (3) 从右向左遍历下层元素，依次为(bottom, right - 1)到(bottom, left + 1)；
     *          (4) 从下向上遍历左侧元素，依次为(bottom - 1, left)到(top + 1, left)。
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 先过滤空矩阵或一维矩阵的情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        // 定义四个方向:

        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            // 从左向右
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            // 从上往下
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                // 从右向左
                for (int col = right - 1; col > left; col--) {
                    res.add(matrix[bottom][col]);
                }
                // 从下向上
                for (int row = bottom; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }
}
