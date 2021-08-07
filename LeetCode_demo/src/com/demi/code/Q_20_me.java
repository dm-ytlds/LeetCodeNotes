package com.demi.code;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 归类：字符串
 * 题目：有效的括号
 */
public class Q_20_me {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isRight(s));
    }

    /**
     * 用栈实现
     * @param s
     * @return
     */
    public static boolean isRight(String s) {
        int n = s.length();
        if (s == null || n == 0) return false;
        // 奇数个括号，也不可能成对
        if (n % 2 != 0) return false;
        // 定义一个栈
        Deque<Character> stack = new LinkedList<>();
        // 预先存储括号对。注意括号对反着存，因为栈中出来的元素是 “先进后出”
        Map<Character, Character> maps = new HashMap<>();
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');
        /*
            遍历字符串中的所有字符（.charAt(i)），如果maps的keys中包含该字符，
            栈顶元素不等于maps中存储的对应元素
         */
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (maps.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != maps.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
