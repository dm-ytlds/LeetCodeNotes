package com.demi.code;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 归类：字符串
 * 题目：整数转罗马数字
 */
public class Q_12_me {
    public static void main(String[] args) {
        int x = 33;
        String get = noToRoma(x);
        System.out.println(get);
    }

    public static String noToRoma(int no) {
        // 用map集合存储所有的可能的罗马字符
        // Map只能一个一个存入，太麻烦
        // Map<Integer, String> maps = new HashMap<>();
        // 改成两个数组。注意要一一对应
        // 通过测试发现，需要将一一对应的关系倒着写，才方便后续的比较输出
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        // 对应过程
        // 用StringBuffer来拼接字符串
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (no >= value) {
                // 一直做减法，直到小于最小的value值为止
                no -= value;
                roman.append(symbol);
            }
            if (no == 0) {
                break;
            }
        }
        return roman.toString();
    }
}
