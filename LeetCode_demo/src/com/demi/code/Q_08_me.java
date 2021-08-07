package com.demi.code;

/**
 * 归类：字符串
 * 题目：字符串转换整数
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31, 2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。
 * 具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
 * 返回整数作为最终结果。
 */
public class Q_08_me {
    public static void main(String[] args) {
        int num = myAtoi("-91283472332");
        System.out.println(num);
    }
    public static int myAtoi(String s) {
        // 如果字符串为空
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 遍历字符串的下标
        int index = 0;
        // 字符串的长度
        int len = s.length();
        // 去掉字符串的前导空格
        while (index < len && s.charAt(index) == ' ') {
            index++;
        }

        // 极端情况 s = "        ";
        if (index == len) {
            return 0;
        }

        // 判断正负数，初始为整数
        int sign = 1;
        // 非数字的情况下，找出正负号，如果都不是，则开始不是以数字开头的，返回0
        if (s.charAt(index) > '9' || s.charAt(index) < '0') {
            if (index < len && s.charAt(index) == '-') {
                sign = -1;
                index++;
            }else if (index < len && s.charAt(index) == '+') {
                sign = 1;
                index++;
            } else {
                return 0;
            }
        }

        // 除了符号位以外，是数字开头的情况
        int res = 0;
        while (index < len && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            // 判断数值是否越界，当前数值是否大于最大整数，或者等于最大整数
            // 如果越界，等于最大或者最小整数
            if (sign == 1 && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(index) > '7'))
                    || sign == -1 && (res * sign < Integer.MIN_VALUE / 10 || (res * sign == Integer.MIN_VALUE / 10 && s.charAt(index) > '8'))) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 不越界的情况。同时，解决了"0032" -> 32这种情况
            res *= 10;
            // 得到当前字符的数字表示。用字符减去字符'0'
            res += s.charAt(index) - '0';
            index++;
        }

        return res * sign;

    }
}

