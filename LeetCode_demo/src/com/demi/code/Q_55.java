package com.demi.code;

/**
 * 题目：跳跃游戏
 * 给定一个非负整数数组nums，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class Q_55 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,4};
        boolean res = canJump(nums);
        System.out.println(res);
    }

    /**
     * 贪心算法
     *  全局最优：每一步尽可能多走，以达到最后位置处；
     *  局部最优：当前可移动的距离尽可能多走，如果还没到终点，就向下一个元素移动。
     * 做法：
     *  找出当前元素能够最远处的下标；
     *  判断是否为最大下标值，若是，返回true；若不是，保存能走的最大步数，继续找下一步能覆盖的最远距离。
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int cover = 0;
        int maxDis = nums.length - 1;
        /*
            注意：这里遍历到的是cover，cover随着下标的移动是动态变化的
            因为i每次移动的范围只能在 cover 的范围内移动，每移动一个元素，cover得到该元素数值（新的覆盖范围）的补充，
             让i继续移动下去，如果没法移动了，说明到不了最后元素的位置;
            cover的每次都取(i + nums[i](该元素数值补充后的范围), cover(本身范围))的较大值
            如果cover大于等于终点下标，直接返回true即可。
        */
        // 循环中的i既表示走到数组的第几个元素下标，
        // 循环终止的条件是：还有没有步数可走，到没到达当前可走的最后一步
        for (int i = 0; i <= cover; i++) {
            // 覆盖范围每次更新到
            cover = Math.max(i + nums[i], cover);
            if (cover >= maxDis)
                return true;
        }
        return false;
    }
}
