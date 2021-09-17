package com.demi.code.tencent;

/**
 * 题目：买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

 */
public class Q_121 {
    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0,9};
        System.out.println(maxProfit(prices));
    }

    /**
     * 双指针实现
     * 思路：
     *  定义一个前指针i和一个后指针j，初始位置，前指针i指向0下标，即第一个元素，后指针j指向1下标，即第二个元素；
     *  有收益的前提是：前一个元素小于后一个元素。所以，对两个元素大小做一个判断：
     *      如果prices[i] >= prices[j]，则前指针i从j的位置开始移动，j向后移动一位；
     *      如果prices[i] < prices[j]，则将其差值prices[j] - prices[i]与当前最大收益maxProfit做一个比较，选出较大的值作为新的maxProfit。
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0;
        int j = 1;
        while (i < prices.length && j < prices.length) {
            if (prices[i] >= prices[j]) {
                i = j;
                j++;
            } else {
                maxProfit = Math.max(maxProfit, prices[j++] - prices[i]);
            }
        }
        return maxProfit;
    }
}
