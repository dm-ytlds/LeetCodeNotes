package com.demi.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 归类：字符串
 * 题目：罗马数转数字
 */
public class Q_13_me {
    public static void main(String[] args) {
        String s = "XXVII";
        int res = romaToInt(s);
        System.out.println(res);
    }

    public static int romaToInt(String s) {
        //String[] symbols = {"I", "V", "X", "L", "C", "D", "M"};
        //int[] values = {1, 5, 10, 50, 100, 500, 1000};
        // 上面的方式不能随时取值
        Map<Character, Integer> maps = new HashMap<>();
        maps.put('I', 1);
        maps.put('V', 5);
        maps.put('X', 10);
        maps.put('L', 50);
        maps.put('C', 100);
        maps.put('D', 500);
        maps.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            int value = maps.get(s.charAt(i));
            // 必须先判断，左小于右
            if (i < s.length() - 1 && value < maps.get(s.charAt(i + 1))) {
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }
}
