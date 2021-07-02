package com.algorithms;

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
        int ans = nums(n);
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
}
