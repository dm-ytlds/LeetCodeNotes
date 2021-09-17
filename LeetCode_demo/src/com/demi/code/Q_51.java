package com.demi.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：N皇后问题
 * 详情见：https://leetcode-cn.com/problems/n-queens/
 */

public class Q_51 {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = solveNQueens(n);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * 还是经典的回溯算法可以解决的问题，只不过这里应该是二维数组来解决问题了，因为这里涉及到行和列两个维度。
     * N皇后对皇后的条件是：
     *  不能同行；
     *  不能同列；
     *  不能同斜线（45度角和135度角量个方向的斜线）
     * @param n
     * @return
     */
    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        // 先布置棋盘
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');
        }
        backTracking(n, 0, chessBoard);
        return res;
    }

    /**
     * 递归实现方法
     * @param n
     * @param row
     * @param chessBoard
     */
    private static void backTracking(int n, int row, char[][] chessBoard) {
        if (row == n) {
            res.add(ArrayAsList(chessBoard));
            return;
        }
        for (int col = 0; col < n; col++) {
            // 如果符合要求，则放皇后
            if (isValid(row, col, n, chessBoard)) {
                chessBoard[row][col] = 'Q';
                backTracking(n, row + 1, chessBoard);
                // 回溯的精髓
                chessBoard[row][col] = '.';
            }
        }
    }

    /**
     * 该方法用来判断该是否符合放皇后的要求
     * @param row
     * @param col
     * @param n
     * @param chessBoard
     * @return
     */
    private static boolean isValid(int row, int col, int n, char[][] chessBoard) {
        // 同列
        for (int i = 0; i < n; ++i) {
            // 如果该列上已经放了皇后，则不可能在放皇后，直接false
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }
        // 45度角斜线上是否有放皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        // 135度角斜线上是否有放皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q')
                return false;
        }
        return true;
    }

    /**
     * 该方法的功能：
     *  将字符数组转换成字符串
     * copyValueOf()方法的作用：
     *  public static String copyValueOf(char[] data): 返回指定数组中表示该字符序列的字符串。
     *  public static String copyValueOf(char[] data, int offset, int count): 返回指定数组中表示该字符序列的字符串。
     * @param chessBoard
     * @return
     */
    private static List<String> ArrayAsList(char[][] chessBoard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessBoard)
            // 将字符数组转换成字符串
            list.add(String.copyValueOf(c));
        return list;
    }

}
