package com.demi.code.tencent;

/**
 * 题目：买卖股票的最佳时机2
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Q_122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,10,3,6,4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 贪心算法实现。
     *  这道题目可能我们只会想，选一个低的买入，在选个高的卖，在选一个低的买入.....循环反复。
     *  如果想到其实最终利润是可以分解的，那么本题就很容易了！
     *
     * 如何分解呢？
     *  假如第0天买入，第3天卖出，那么利润为：prices[3] - prices[0]。
     *  相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
     *  此时就是把利润分解为每天为单位的维度，而不是从0天到第3天整体去考虑！
     *  那么根据prices可以得到每天的利润序列：(prices[i] - prices[i - 1]).....(prices[1] - prices[0])。
     *
     * 从图中可以发现，其实我们需要收集每天的正利润就可以，收集正利润的区间，就是股票买卖的区间，而我们只需要关注最终利润，不需要记录区间。
     * 那么只收集正利润就是贪心所贪的地方！
     * 局部最优：收集每天的正利润，全局最优：求得最大利润。
     * 局部最优可以推出全局最优，找不出反例，试一试贪心！
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            // 收集正值
            res += Math.max(prices[i] - prices[i - 1], 0);
        }
        return res;
    }
}
