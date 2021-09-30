package com.demi.code;


import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：分割字符串2
 */
public class Q_132 {
    public static void main(String[] args) {
        String s = "abbd";
        System.out.println(minCut02(s));

    }

    public static int minCut01(String s) {

        if (s.length() < 2) {
            return 0;
        }
        if (s.length() == 2) {
            return 1;
        }

        /* 1.dp 数组以及下标的含义：
            dp[i]：范围是[0, i]的回文子串，最少分割次数是dp[i]。
            比如：i = 3时，表示，在范围[0, 3]上的回文子串，最少的分割次数为dp[3]。
            也就是说，范围上的dp值和之前的dp值有关。

            2.确定递推公式
            假如，想要对长度为[0, i]的子串进行分割，分割点为j；
            那么分割后，如果区间[j + 1, i]是回文子串，则dp[i]=dp[j] + 1。
            为什么不需要考虑区间[0, j]是否为回文子串呢？模拟一遍就知道为什么不需要判断区间[0, j]。
            且根据dp[i]的定义可知，范围[0, i]上的回文子串，最少的分割次数是dp[i]。所以[0, j]上的最小切割次数为dp[j]。
            本题需要找的是最少分割次数，所以遍历的时候要取最小的dp[i]。
            所以，找到了递推公式：dp[i] = Math.min(dp[i], dp[j] + 1);
         */
        // 定义动态数组
        int[] dp = new int[s.length()];
        /*
            3.如何初始化dp数组
            初始化，很容易想到dp[0] = 0，当字符串为空时，不可能是回文子串，所以不需要划分。
            非0的dp[i]值怎么初始化呢？
            由于需要找到非0下标的dp[i]的最小切割次数，所以按理说就应该将每一个非0小标的dp[i]值初始化为最大值，
            这样递推公式计算完结果时，才不会被初始值覆盖。
            当然，也可以直接将dp[i] = i就行，找的是切割最小值，所以按理说，切割次数不会大于当前的切割次数，所以效果是一样的。
         */
        // 初始化dp数组如下
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
        }
        // 4.确定遍历顺序。从头到尾，依次遍历字符串
        for (int i = 1; i < s.length(); i++) {
            // 如果区间[0 , i]上已经是回文子串，则不需要切割了，所以切割次数设置为0。继续向下遍历
            if (isCallBack(s,0, i)) {
                dp[i] = 0;
                continue;
            }
            // 下面是区间[0, i]不是回文子串的情况。遍历其中的子串是否有回文子串。所以便利的终止条件是i
            for (int j = 0; j < i; j++) {
                // 如果子串[j + 1, i]是回文子串，则根据递推公式,dp[i] = Math.min(dp[i], dp[j] + 1);
                if (isCallBack(s, j + 1, i)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        // 返回最终结果
        return dp[s.length() - 1];
    }

    /**
     * 执行用时： 681 ms, 在所有 Java 提交中击败了10.43%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了89.72%的用户
     *
     * 这种判断是否为回文的方式太耗时长了。
     * @param s
     * @param start
     * @param end
     * @return
     */
    private static boolean isCallBack(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    // 用动态规划的方式判断是否为回文子串
    public static int minCut02(String s) {
        // 初始化一个二维数组，先找出字符串中的回文子串
        boolean isCallBack[][] = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        isCallBack[i][j] = true;
                    } else if (isCallBack[i + 1][j - 1]) {
                        isCallBack[i][j] = true;
                    }
                }
            }
        }

        int dp[] = new int[s.length()];
        // 别忘了初始化
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
        }
        for (int i = 1; i < s.length(); i++) {
            if (isCallBack[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isCallBack[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length() - 1];
    }
}
