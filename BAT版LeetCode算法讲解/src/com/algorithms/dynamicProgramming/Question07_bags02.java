package src.com.algorithms.dynamicProgramming;

/**
 * 背包容量为weights
 * 一共有n袋零食，第i袋零食体积为v[i] > 0
 * 总体积不超过背包容量。
 * 一共有多少种零食的放法？（总体积为0也算一种放法）。
 */
public class Question07_bags02 {
    public static void main(String[] args) {
        int[] arr = {};
    }
    public static int ways01(int[] arr, int weights) {
        return process(arr, 0, weights);
    }

    /**
     * 从左往右的经典模型
     * @param arr
     * @param index
     * @param rest
     * @return
     */
    private static int process(int[] arr, int index, int rest) {
        // 如果背包容量本身小于0，那么没有方案
        if (rest < 0) {
            return -1;
        }
        // 已经选到最后一个了，无零食可选了
        if (index == arr.length) {
            return 1;
        }

        // index号零食，要 or 不要
        // 不要
        int next1 = process(arr, index + 1, rest);
        // 要
        int next2 = process(arr, index + 1, rest - arr[index]);
        return next1 + (next2 == -1 ? 0 : next2);
    }

    /**
     * 动态规划
     * @param arr
     * @param weights
     * @return
     */
    public static int way02(int[] arr, int weights) {
        if (weights < 0) {
            return -1;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][weights + 1];
        dp[N][0] = 1;
        for (int index = 1; index < N; index++) {
            for (int rest = 1; rest <= weights; rest++) {
                dp[index][rest] = dp[index - 1][rest] + (rest - arr[index]) >= 0 ? dp[index -1][rest - arr[index]] : 0;
            }
        }
        // 统计最终的可能性
        int res = 0;
        // N - 1行的所有列元素之和
        for (int i = 0; i <= weights; i++) {
            res += dp[N - 1][i];
        }
        return res;
    }
}
