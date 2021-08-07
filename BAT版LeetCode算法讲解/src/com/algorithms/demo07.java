package src.com.algorithms;

public class  demo07 {
    public static void main(String[] args) {

    }

    public static int way01(int N, int M, int K, int P) {
        // 参数无效的情况
        if (N < 2 || K < 1 || M < 1|| M > N || P < 1 || P > N) {
            return 0;
        }
        return walk01(N, M , K, P);
    }
    /**
     * 该方法的定义：只能在1~N这些位置上移动，当前位置为curr，走完rest步之后，停在P位置的方法数
     * @param N   步行总长度，固定参数
     * @param curr  机器人当前所在的位置，可变参数
     * @param rest  还剩rest步可以走，可变参数
     * @param P     最终目标位置是P，固定参数
     * @return
     */
    public static int walk01(int N, int curr, int rest, int P) {
        /*
        * 如果没有剩余步数，当前curr位置就是最后的位置
        * 如果最后位置停在P上，那么之前做的移动就是有效的
        * 如果最后位置没在P上，那么之前做的移动就是无效的
        * */
        if (rest == 0) {
            return curr == P ? 1 : 0;
        }
        /*
        * 如果还有rest步要走，而当前的curr位置在1位置上，那么当前这步只能从1走向2
        * 后续的过程就是：来到2位置上，还剩rest - 1步要走
        * */
        if (curr == 1) {
            return walk01(N, 2, rest - 1, P);
        }
        if (curr == N) {
            return walk01(N, N - 1, rest - 1, P);
        }
        /*
        * 如果还有rest步要走，而当前的curr位置在中间位置上，那么当前这步可以走向左，也可以走向右
        * 走向左之后，后续的过程就是：来到curr - 1位置上，还剩rest - 1步要走
        * 走向右之后，后续的过程就是：来到curr + 1位置上，还剩rest - 1步要走
        * 走向左、走向右是截然不同的方法，所以总方法数要都算上
        * */
        return walk01(N, curr + 1, rest - 1, P) + walk01(N, curr - 1, rest - 1, P);
    }

    /**
     * way01 会出现很多的重复计算过程。
     * 增加一个缓存变量，就可以控制重复计算。
     * dp表（动态规划）的使用。
     * 这里的动态规划，又叫做“记忆化搜索”
     * @param N
     * @param M
     * @param K
     * @param P
     * @return
     */
    public static int way02(int N, int M, int K, int P) {
        // 参数无效的情况
        if (N < 2 || K < 1 || M < 1|| M > N || P < 1 || P > N) {
            return 0;
        }
        // 定义dp二维数组，来缓存已经求过的参数有效的情况
        int[][] dp = new int[N + 1][K + 1];
        // 初始化dp表的值为-1，表示还没有使用过
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < K; col++) {
                dp[row][col] = -1;
            }
        }
        return walk02(N, M , K, P, dp);
    }
    /**
     * 该方法的定义：只能在1~N这些位置上移动，当前位置为curr，走完rest步之后，停在P位置的方法数
     * @param N   步行总长度，固定参数
     * @param curr  机器人当前所在的位置，可变参数
     * @param rest  还剩rest步可以走，可变参数
     * @param P     最终目标位置是P，固定参数
     * @return
     */
    public static int walk02(int N, int curr, int rest, int P, int[][] dp) {
        if (dp[curr][rest] != -1) {
            return dp[curr][rest];
        }
        /*
         * 如果没有剩余步数，当前curr位置就是最后的位置
         * 如果最后位置停在P上，那么之前做的移动就是有效的
         * 如果最后位置没在P上，那么之前做的移动就是无效的
         * */
        if (rest == 0) {
            dp[curr][rest] = curr == P ? 1 : 0;
            return dp[curr][rest];
        }
        /*
         * 如果还有rest步要走，而当前的curr位置在1位置上，那么当前这步只能从1走向2
         * 后续的过程就是：来到2位置上，还剩rest - 1步要走
         * */
        if (curr == 1) {
            dp[curr][rest] = walk02(N, 2, rest - 1, P, dp);
            return dp[curr][rest];
        }
        if (curr == N) {
            dp[curr][rest] = walk02(N, N - 1, rest - 1, P, dp);
            return dp[curr][rest];
        }
        /*
         * 如果还有rest步要走，而当前的curr位置在中间位置上，那么当前这步可以走向左，也可以走向右
         * 走向左之后，后续的过程就是：来到curr - 1位置上，还剩rest - 1步要走
         * 走向右之后，后续的过程就是：来到curr + 1位置上，还剩rest - 1步要走
         * 走向左、走向右是截然不同的方法，所以总方法数要都算上
         * */
        dp[curr][rest] = walk02(N, curr + 1, rest - 1, P, dp) + walk02(N, curr - 1, rest - 1, P, dp);
        return dp[curr][rest];
    }
}
