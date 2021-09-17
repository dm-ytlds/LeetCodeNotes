package com.demi.code;

import java.util.Arrays;

/**
 * 题目：螺旋矩阵2
 * 给定一个正整数n，生成一个包含1到n^2的所有元素，且元素按照顺时针顺序螺旋排列的n*n正方形矩阵matrix。
 */
public class Q_59 {
    public static void main(String[] args) {
        int n = 3;
        int[][] res = generateMatrix(3);
        System.out.println(Arrays.deepToString(res));
    }

    /**
     * 模拟过程，和54题一样，只是这里是填数，54题是取数。
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] intervals = new int[n][n];
        int index = 1;
        int top = 0, left = 0, bottom = n - 1, right = n - 1;
        while (top <= bottom && left <= right) {
            // 从左到右 上层  针对循环区间而言：左开右闭
            for (int col = left; col <= right; col++) {
                intervals[top][col] = index++;
            }
            // 从上到下 右侧  针对循环区间而言：左开右闭
            for (int row = top + 1; row <= bottom; row++) {
                intervals[row][right] = index++;
            }
            if (top < bottom && left < right) {
                // 从右向左 下层  针对循环区间而言：左闭右开
                for (int col = right - 1; col > left; col--) {
                    intervals[bottom][col] = index++;
                }
                // 从下到上 左侧  针对循环区间而言：左闭右开
                for (int row = bottom; row > top; row--) {
                    intervals[row][left] = index++;
                }
            }
            left++;
            top++;
            bottom--;
            right--;
        }
        return intervals;
    }
}
