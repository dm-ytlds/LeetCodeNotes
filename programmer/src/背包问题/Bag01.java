package 背包问题;

/**
 * 题目描述：
 * 共有物品0、1、2，重量分别为：1、3、4，价值分别为：15、20、30，有一个背包的最大重量为4，请问：装满背包的最大价值是多少。
 */
public class Bag01 {
    private static int maxValue(int[] weights, int[] values, int bagSize) {
        // 1. 确定dp数组，其中weights.length为物品的数量，dp数组代表的价值
        int n = weights.length;
        int[][] dp = new int[n][bagSize + 1];
        // 2. 确定递推公式
        // 3. 初始化dp数组 第一行和第一列
        // 初始化第一行 行代表的是背包可能装的重量，所以应该是遍历背包的大小
        for (int i = weights[0]; i <= bagSize; i++) {
            dp[0][i] = values[0];
        }
        // 初始化第一列 列代表的是可能放进背包的物品，其实在创建dp数组时，默认就是全部初始化为0，因此这一步可以不要
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        // 确定遍历书序，填充dp数组
        // 必然是两层for循环 第一层为遍历背包可能放进的物品，第二层为背包可能的容量
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weights[i]) {
                    /*
                        当前背包的容量都没有当前物品i的重量大时，时不放进该物品的，
                        那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /*
                        当前背包的容量可以放进物品i
                        那么此时分两种情况：
                            不放进物品i和放进物品i
                        比较两种情况下的最大值就是背包的最大价值
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        // 打印最大的价值
        return dp[n - 1][bagSize];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        System.out.println(maxValue(weight, value, bagSize));
    }
}
