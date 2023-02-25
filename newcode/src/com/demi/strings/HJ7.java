package com.demi.strings;

import java.util.Scanner;

public class HJ7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            // 输入的浮点数字符串
            String str = in.nextLine();
            String[] strs = str.split("\\.");
            // 后半段字符串的首字符
            int len = strs[1].length();
            // 首字符
            char c = strs[1].charAt(0);
            if ((c - '5') < 0) {
                // 小于0.5，向下取整
                System.out.println(strs[0]);
            } else {
                System.out.println(Integer.parseInt(strs[0]) + 1);
            }
        }
    }
}
