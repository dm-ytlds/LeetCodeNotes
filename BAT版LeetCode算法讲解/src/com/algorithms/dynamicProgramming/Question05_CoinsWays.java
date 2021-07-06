package src.com.algorithms.dynamicProgramming;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 题目要求：
 *  给定货币的面值数组[10, 3, 7, 5, 100]。
 *  找出能够凑成1000元，有多少种方法。
 */
public class Question05_CoinsWays {
    public static void main(String[] args) {
        int[] coins = {10, 3, 7, 5, 100};
        int aim = 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH : mm : ss");

        System.out.println(new Date());
        System.out.println(ways01(coins,aim) + ", " + sdf.format(new Date()));
        System.out.println(dpWays(coins,aim) + ", " + sdf.format(new Date()));
        System.out.println(dpWays02(coins,aim) + ", " + sdf.format(new Date()));
        System.out.println(dpWays03(coins,aim) + ", " + sdf.format(new Date()));
    }

    public static int ways01(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process01(arr, 0, aim);
    }
    /**
     * 暴力递归求解
     * @param arr   货币面值数组
     * @param index 数组的下标[0...arr.length]
     * @param rest  所需要凑成的钱
     * @return  返回方法总数
     */
    public static int process01(int[] arr, int index, int rest) {
        /*if (rest < 0) {
            return 0;
        }*/
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        // 初始化方法数
        int nums = 0;
        // i 是每张面值货币所用的张数
        for (int i = 0; i * arr[index] <= rest; i++) {
            nums += process01(arr, index + 1, rest - i * arr[index]);
        }
        return nums;
    }

    /**
     * 记忆化搜索
     * @param arr
     * @param aim
     * @return
     */
    public static int dpWays(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        // 创建dp表

        int[][] dp = new int[arr.length + 1][aim + 1];
        // 给dp表初始化
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process02(arr, 0, aim, dp);
    }

    /**
     * 如果index和rest的参数组合，是没有算过的，dp[index][rest] == -1
     * 如果index和rest的参数组合，是算过的，dp[index][rest] > -1
     * @param arr
     * @param index
     * @param rest
     * @param dp
     * @return
     */
    private static int process02(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
        }
        // 初始化方法数
        int nums = 0;
        // i 是每张面值货币所用的张数
        for (int i = 0; i * arr[index] <= rest; i++) {
            nums += process01(arr, index + 1, rest - i * arr[index]);
        }
        dp[index][rest] = nums;
        return nums;
    }

    /**
     * 动态规划 01 粗糙版
     * @param arr
     * @param aim
     * @return
     */
    public static int dpWays02(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // index == arr.length的情况
        dp[N][0] = 1;
        // 当前dp位置的值都依赖下一行
        // 初始就以行倒序的方式进行遍历index(行)
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int i = 0; i * arr[index] <= rest; i++) {
                    ways  += dp[index + 1][rest - i * arr[index]];
                }
                dp[index][rest] = ways;
            }
        }

        return dp[0][aim];
    }

    /**
     * 动态规划 02 优化版
     * @param arr
     * @param aim
     * @return
     */
    public static int dpWays03(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        // 当前dp位置的值都依赖下一行
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {

                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest]  += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }
}
