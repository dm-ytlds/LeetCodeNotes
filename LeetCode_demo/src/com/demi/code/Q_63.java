package com.demi.code;

/**
 * 题目：不同路径 2
 * 要求和62题类似，多考虑一个问题：网格中有障碍物的情况。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class Q_63 {
    public static void main(String[] args) {
        int[][] o = {{0, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(o));
    }

    /**
     * 将有障碍物的位置对应的dp数组值置为0即可。其他解题思路和Q62一样。
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 1. 确定dp数组以及下标的含义
        int[][] dp = new int[m][n];
        // 2. 确定递推公式：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        // 初始化dp数组。确保第0行和第0列无障碍物在初始化
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
