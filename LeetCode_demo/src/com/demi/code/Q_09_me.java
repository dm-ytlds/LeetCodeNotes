package com.demi.code;

/**
 * 归类：数字
 * 题目：回文数字
 */
public class Q_09_me {
    public static void main(String[] args) {
        int num = 121;
        boolean isRight = isCallback(num);
        System.out.println(isRight);
    }

    public static boolean isCallback(int num) {
        // 如果数字小于0，必不可能是回文数字
        if (num < 0) {
            return false;
        }
        // 保存原始的数字x
        int o_num = num;
        // 保存数字翻转后的结果
        int res = 0;
        while (num != 0) {
            int temp = num % 10;
            res = res * 10 + temp;
            num = num / 10;
        }
        return o_num == res ? true : false;
    }
}
