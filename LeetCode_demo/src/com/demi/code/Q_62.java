package com.demi.code;

/**
 * 题目：不同路径
 * 一个机器人位于一个m x n的网格的左上角。
 * 机器人每次只能向下或者向右移动一步。机器人视图达到网格的右下角。
 * 问：总共有多少条不同的路径。
 *
 */
public class Q_62 {
    public static void main(String[] args) {
        int m = 3, n = 5;
        System.out.println(uniquePaths(m, n));
    }

    /**
     * 我们用 f(i, j) 表示从左上角走到 (i, j) 的路径数量，其中 i 和 j 的范围分别是 [0, m) 和 [0, n)。
     * 由于我们每一步只能从向下或者向右移动一步，
     * 因此要想走到 (i, j)，如果向下走一步，那么会从 (i-1, j)走过来；
     * 如果向右走一步，那么会从 (i, j-1) 走过来。因此我们可以写出动态规划转移方程：
     *      f(i, j) = f(i-1, j) + f(i, j-1)
     *
     * 需要注意的是，如果 i=0，那么 f(i-1,j) 并不是一个满足要求的状态，我们需要忽略这一项；
     * 同理，如果 j=0，那么 f(i,j-1) 并不是一个满足要求的状态，我们需要忽略这一项。
     * 初始条件为 f(0,0)=1，即从左上角走到左上角有一种方法。
     * 最终的答案即为 f(m-1,n-1)。
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][]dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }
        for (int col = 0; col < n; col++) {
            dp[0][col] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
