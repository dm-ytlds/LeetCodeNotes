package src.com.algorithms;

import java.util.Scanner;

/**
 * N皇后问题-->递归求解
 *
 */
public class demo06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入行列数（行数和列数一样）：");
        int n = sc.nextInt();
        int ans = nums02(n);
        System.out.println(n + "行" + n + "列所对应的皇后个数为：" + ans);


    }

    public static int nums(int n) {
        if (n == 1) {
            return 0;
        }
        int[] nums = new int[n];
        int ans = process(0, nums, n);
        return ans;
    }

    /**
     * 只用一维数组int[] record来记录“皇后”所在的位置。
     *  其中，i为行数，record[i]为列数。
     *  n代表整体一共有多少行
     *
     * @param i
     * @param record
     * @param n
     * @return  返回合理的摆法有多少种
     */
    public static int process(int i, int[] record, int n) {
        int res = 0;
        // 到达终止行，返回一个结果
        if (i == n) {
            return 1;
        }
        for (int j = 0; j < n; j++) {
            if(isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    /**
     *
     * @param record
     * @param i  行数
     * @param j  列数
     * @return
     */
    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if(j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static int nums02(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        // 如果是13皇后问题，limit最右侧13个'1'，其他都是'0'
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process02(limit, 0, 0, 0);
    }

    /**
     *
     * @param limit  划定了问题的规模 --> 固定
     * @param colLim    列的限制，1的位置不能放皇后，0的位置可以
     * @param leftDiaLim    左斜线的限制，1的位置不能放皇后，0的位置可以
     * @param rightDiaLim   右斜线的限制，1的位置不能放皇后，0的位置可以
     * @return
     */
    public static int process02(
            int limit,
            int colLim,
            int leftDiaLim,
            int rightDiaLim
    ) {
        if (colLim == limit) {
            return 1;
        }
        // 所有可以放皇后的位置，都在pos上
        // colLim | leftDiaLim | rightDiaLim    --> 总限制
        // ~(colLim | leftDiaLim | rightDiaLim)   --> 左侧的一堆0干扰，右侧每个1都可尝试
        int pos = limit & ( ~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            // 取出pos中，最右侧的 '1' 来，剩下的位置都是 0
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process02(limit,
                    colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1
                    );
        }
        return res;
    }
}
