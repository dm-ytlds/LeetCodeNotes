package com.demi.code;

import java.util.Arrays;

/**
 * 题目：最小路径和
 *
 */
public class Q_64 {
    public static void main(String[] args) {
        int[][] in = {{1, 2, 3}, {4, 5, 6}};
        int res = minPathSum(in);
        System.out.println(res);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 每一个数都是依赖左边和上边的数字，所以先把左边一列和上边一行的所有数字先算出来。
        // 第0列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 第0行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 输出初始化的dp数组
        // System.out.println(Arrays.deepToString(dp));

        // 填dp数组的值。dp数组中，每个数的左边和上边两个数字都是上一步求得的较小值，做比较，选出较小的数值和当前元素值相加作为当前dp数组的数值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
