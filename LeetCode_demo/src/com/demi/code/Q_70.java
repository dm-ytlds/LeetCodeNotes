package com.demi.code;

/**
 * 题目：爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 */
public class Q_70 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }

    /**
     * dp[i]的定义：爬到第i层楼梯，有dp[i]中方法。
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
