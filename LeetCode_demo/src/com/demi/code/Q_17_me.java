package com.demi.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 归类：数组
 * 题目：电话号码的字母组合
 */
public class Q_17_me {
    public static void main(String[] args) {

    }

    public static List<String> letterCombinations(String digits) {
        // 存储最终结果
        List<String> conbs = new ArrayList<>();
        int n = digits.length();
        // 空串
        if (n == 0) {
            return conbs;
        }
        // 列举出所有的数字对应的字符串，用HashMap集合实现
        Map<Character, String> phoneMaps = new HashMap<>();
        // 1对应的不是字母字符串，从2开始
        phoneMaps.put('2', "abc");
        phoneMaps.put('3', "def");
        phoneMaps.put('4', "ghi");
        phoneMaps.put('5', "jkl");
        phoneMaps.put('6', "mno");
        phoneMaps.put('7', "pqrs");
        phoneMaps.put('8', "tuv");
        phoneMaps.put('9', "wxyz");

        // 回溯法，找所有可能
        backTrack(conbs, phoneMaps, digits, 0, new StringBuffer());
        return conbs;
    }
    private static void backTrack(List<String> conbs, Map<Character, String> phoneMaps, String digits, int index, StringBuffer conb) {
        // 首先判断index是否等于需要查找字符串的长度，即查找是否结束，
        // 若查找结束，直接返回结果
        if (index == digits.length()) {
            conbs.add(conb.toString());
        } else {
            // 从第一个字符开始查找
            char digit = digits.charAt(index);
            String letters = phoneMaps.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                conb.append(letters.charAt(i));
                backTrack(conbs, phoneMaps, digits, index + 1, conb);
                // 删除已遍历的字符
                conb.deleteCharAt(index);
            }
        }


    }
}
