package src.com.algorithms.dynamicProgramming;
/** 背包题型
 *
 *  给定两个长度都为N的数组weights和values，
 *  weight[i]和value[i]分别代表i号物品的重量和价值。
 *  给定一个正数bag，表示一个载重bag的袋子，
 *  你装的物品不能超过这个重量bag。
 *  返回你能装下最多的价值是多少。
 *
 */
public class Question02 {
    public static void main(String[] args) {
        // test
        int[] weights = {2, 1, 3, 5, 4};
        int[] values = {5, 6, 3, 19, 2};
        int bag = 7;
        System.out.println(dpWay(weights, values, bag));
    }

    /**
     * index: 货物自由选择，但是对应的值W[index]不能超过bag可存储的空间；
     * rest: 还剩下可以装货物 (bag - W[index]) 的空间大小。
     * @param W
     * @param V
     * @param bag
     * @return
     */
    public static int dpWay(int[] W, int[] V, int bag) {
        // 计算出weights的维度
        int N = W.length;
        // 将weights的维度作为dp表的行数，用载重bag作为dp表的列数
        // dp表缓存的是每个位置对应的bag所装的value
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = -1;
                // 如果说，剩余的可装重量还足以装下W[index]，则继续

                if (rest - W[index] >= 0) {
                    // p2的值：该索引处对应的value，加上dp表中缓存的value值
                    p2 =V[index] + dp[index + 1][rest - W[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        // 返回第一行的bag列的值
        return dp[0][bag];
    }
}
