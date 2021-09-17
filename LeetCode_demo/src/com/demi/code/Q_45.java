package com.demi.code;

/**
 * 题目：跳跃游戏2
 *
 */
public class Q_45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4};
        int jump = jump03(nums);
        System.out.println(jump);
    }



    /**
     * method01
     * @param nums
     * @return
     */

    public static int jump01(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            // 初始化一个较大的值
            dp[i] = nums.length + 1;
        }
        for (int i = 1; i < nums.length; i++) {
            // 内存循环是从0开始一直找到当前外层循环的位置
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    /**
     *
     * @param nums
     * @return
     */
    private static int jump02(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = len + 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= len)
                    return dp[len - 1];
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }

        }
        return dp[len - 1];
    }

    /**
     * 贪心算法的思路：
     *      局部最优：当前可移动距离尽可能多走，如果还没到终点，步数再加一。整体最优：一步尽可能多走，从而达到最小步数。
     * 找出当前元素能够覆盖的最远距离的下标
     * 记录能走的最大步数
     * 以及下一步能够覆盖的最远距离下标
     * @param nums
     * @return
     */
    private static int jump03(int[] nums) {
        // 当前元素能够覆盖的最远距离下标
        int curCoverDis = 0;
        // 能够走的最大步数
        int maxStep = 0;
        // 下一个元素能够覆盖的最远距离下标
        int nextCoverDis = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 在可覆盖区域内更新最大的覆盖区域
            // nums[i] + i：移动到第i个元素了，说明至少可以走i步
            nextCoverDis = Math.max(nums[i] + i, nextCoverDis);

            // 移动下标只要遇到当前覆盖最远距离的下标，更新当前下标为下一步覆盖的最远距离的下标，步数直接加一，不用考虑别的了。
            if (i == curCoverDis) {
                curCoverDis = nextCoverDis;
                maxStep++;
            }
        }
        return maxStep;
    }

}
