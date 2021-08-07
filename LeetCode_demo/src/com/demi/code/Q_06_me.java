package com.demi.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 归类：字符串
 * 题目：Z字形变换
 * s = "PAYPALISHIRING", numRows = 3
 *      P       A       H       N
 *      A   P   L   S   I   I   G
 *      Y       I       R
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，
 * 比如："PAHNAPLSIIGYIR"。
 */
public class Q_06_me {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String res = ZConverse(s, 4);
        System.out.println(res);
    }

    /**
     * 思路：用到双指针。一个指针为行指针，一个指针为遍历字符串的指针。
     *      整个过程就是：不断的调整行指针和遍历字符串的指针，主要是对行指针的上、下、右的变换。
     *      同时巧妙的运用StringBuilder数组来拼接每一行的字符，减少了String重复new实例对象的存储空间浪费，同时避免了用到二维数组的复杂。
     * @param s
     * @param numRows
     * @return
     */
    public static String ZConverse(String s, int numRows) {
        int len = s.length();
        // 如果字符串的长度为1
        if (len == 1) {
            return s;
        }
        // index为遍历字符串的指针
        int index = 0;
        // 创建一个StringBuilder数组，存储每一行的字符串
        StringBuilder[] sb = new StringBuilder[numRows];
        // 首先通过指定的numRows行数制定多少个StringBuilder实例
        for (int i = 0; i < numRows; i++) {
            // 每一行都创建一个sb实例对象，方便字符的拼接
            sb[i] = new StringBuilder();
        }
        // 开始遍历字符串
        int row = 0;
        while (index < len) {
            while (index < len && row < numRows) {
                // 向下存储。即从第0行开始，存储到第numRows - 1行
                sb[row].append(s.charAt(index++));
                row++;
            }
            // 字符串遍历完
            if (index == len) {
                break;
            }
            // 当存完一列，指针开始右移，存储过程从下往上
            // 因为row是从0开始的，所以返回上一行应该 -2
            row = numRows - 2;
            while (index < len && row >= 0) {
                sb[row].append(s.charAt(index++));
                row--;
            }
            // 向上的过程结束后，row的值为-1，而行指针下一步需要指到1，为了恢复行指针的指向，所以row + 2
            row += 2;
        }

        // 遍历结束，将每一行的sb存在同一个sb里
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(sb[i]);
        }
        return res.toString();
    }
}
