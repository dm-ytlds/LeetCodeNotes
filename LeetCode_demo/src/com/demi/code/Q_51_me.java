package com.demi.code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后问题
 *
 */
public class Q_51_me {
    public static void main(String[] args) {
        int n = 3;
        List<List<String>> ret = queenN(4);
        System.out.println(Arrays.toString(ret.toArray()));
    }

    /**
     * 解题思路：
     *      (1) 初始化棋盘;
     *      (2) 考虑不可以放皇后的条件：同列、同行、斜左向上、斜右向上
     *      (3) 将二维字符数组转换成列表形式
     * @param n
     * @return
     */
    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> queenN(int n) {
        char[][] cheeseBoard = new char[n][n];
        for (int row = 0; row < n; row ++) {
            for (int col = 0; col < n; col++) {
                cheeseBoard[row][col] = '.';
            }
        }
        // 回溯
        backTracking(n, 0, cheeseBoard);
        return res;
    }

    private static void backTracking(int n, int row, char[][] cheeseBoard) {
        if (row == n) {
            res.add(array2List(cheeseBoard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(n, row, col, cheeseBoard)) {
                cheeseBoard[row][col] = 'Q';
                backTracking(n, row + 1, cheeseBoard);
                cheeseBoard[row][col] = '.';
            }
        }
    }

    // 将棋盘结果的二维字符数组转成列表
    private static List<String> array2List(char[][] cheeseBoard) {
        List<String> ans = new ArrayList<>();
        for (char[] c : cheeseBoard) {
            ans.add(String.copyValueOf(c));
        }
        return ans;
    }

    /**
     * 判断满足放皇后的条件
     * @param n
     * @param row
     * @param col
     * @param cheeseBoard
     * @return
     */
    private static boolean isValid(int n, int row, int col, char[][] cheeseBoard) {
        // 同列
        for (int i = 0; i < n; i++) {
            if (cheeseBoard[i][col] == 'Q')
                return false;
        }
        // 左斜向上
        for (int i = row - 1, j = col - 1; i >=0 && j>= 0; i--, j--) {
            if (cheeseBoard[i][j] == 'Q')
                return false;
        }
        // 右斜向上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (cheeseBoard[i][j] == 'Q')
                return false;
        }
        return true;
    }


}
