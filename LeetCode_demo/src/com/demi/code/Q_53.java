package com.demi.code;

/**
 * 题目：最大子序和
 *  给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *  示例：
 *      输入：[-2,1,-3,4,-1,2,1,-5,4]
 *      输出：6
 *      解释：连续子数组[4,-1,2,1]的和最大为6。
 */
public class Q_53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray03(nums);
        System.out.println(res);
    }

    /**
     * 动态规划求解
     * @param nums
     * @return
     */
    private static int maxSubArray03(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }

    /**
     *  暴力求解思路：
     *      初始化一个最终值res，注意：初始化的res值为整型数的最小值，因为这里需要考虑负数的情况；
     *      每次当遍历到一个新数值，就将数值加进计数器count（初始化为0）里，然后将res与count作比较，较大的值作为下一次的res值。
     * @param nums
     * @return
     */
    public static int maxSubArray01(int[] nums) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                // 比较出最大的值
                res = count > res ? count : res;
            }
        }
        return res;
    }

    /**
     * 贪心算法求解。
     *  贪心贪在哪？
     *      如果-2的下一个数字为1，计算器点的时候，一定是从1开始计算的，因为负数只会拉低综合，这就是贪心算法贪的地方。
     *  局部最优：当前“连续和”为负数的时候立即放弃，从下一个元素重新计算“连续和”；
     *  全局最优：选取最大“连续和”。
     *  局部最优的情况下，记录最大的“连续和”，可以退出全局最优。
     * @param nums
     * @return
     */
    private static int maxSubArray02(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > res)
                res = count;
            if (count <= 0)
                count = 0;
        }
        return res;
    }

}
