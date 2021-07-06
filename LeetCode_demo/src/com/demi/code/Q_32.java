package com.demi.code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/** 题目：最长有效括号
 *  题目描述：给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *  有效：必须先是 左括号， 后是 右括号；
 *  连续：有了有效括号后，后面的有效括号必须是连续的。
 *  比如："()()" 是正确格式，而"()(()"就是非连续的有效括号。
 *
 *  示例 1：
 *      输入：s = "(()"
 *      输出：2
 *      解释：最长有效括号子串是 "()"
 *  示例 2：
 *      输入：s = ")()())((()))"
 *      输出：6
 *      解释：最长有效括号子串是 "((()))"
 *  示例 3：
 *      输入：s = ""
 *      输出：0
 */
public class Q_32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入括号字符串：");
        String s = sc.next();
        System.out.println("最长有效括号子串长度为：" + longestValidParentheses(s));
        System.out.println("最长有效括号子串长度为：" + longestValidParentheses02(s));
    }

    /**
     *  定义dp[i]数组表示以下标i字符结尾的最长有效括号的长度。
     *  有效括号子串一定是以')'括号结尾的，因此只需要知道以'('结尾的子串对应的dp值必定为0，
     *  只需要求解')'在dp数组中对应位置的值。
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        /*if (s.length() == 0 || s == null) {
            return 0;
        }*/
        int maxMatch = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                /*if (s.charAt(i - 1) == ')') {
                    dp[i] = dp[i - 1] + dp[i - dp[i - dp[i - 2] - 2] + 2];
                }*/
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    }else {
                        dp[i] = 2;
                    }
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxMatch = Math.max(maxMatch, dp[i]);
            }
        }
        return maxMatch;
    }

    /**
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses02(String s) {
        int left = 0, right = 0, maxlength = 0;
        // 从左到右遍历
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                // 如果右括号比左括号多，将左右括号重新初始化
                left = right = 0;
            }
        }
        // 从右往左遍历
        left = right = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
