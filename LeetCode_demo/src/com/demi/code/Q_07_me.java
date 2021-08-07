package com.demi.code;

/**
 * 归类：数字
 * 题目：整数反转
 * !!!:有问题
 * 重点掌握：取模运算的规则。取模运算包含正负号。
 *
 */
public class Q_07_me {
    public static void main(String[] args) {
        Solution qus = new Solution();
        int num = 2147483647;
//        System.out.println(qus.reverse(num));
        System.out.println(qus.intReverse(num));
    }
}

class Solution {
    public int intReverse(int num) {
        int res = 0;
        // 注意符号位的处理
        // 符号位：若第一个字符为'-'，先保存下来，然后在反转后面数字
        // 否则，直接反转数字
        // 将数字转换成字符串
        String sNum = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        if (sNum.charAt(0) == '-') {
            // 首字符为"-"，负整数的情况
            sb.append("-");
            // 反转剩余的字符串
            int newNum = Math.abs(num);
            String re = reverse(newNum);
            sb.append(re);

        } else {
            // 正整数的情况
            String re = reverse(num);
            sb.append(re);
        }
        // 出错的原因：本身已经超过int最大数值的字符串不能转换成int类型，所以或出现NumberFormatException异常。
        res = Integer.valueOf(sb.toString());
        if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
            return 0;
        }
        return res;
    }

    public String reverse(int n) {
        StringBuilder sb = new StringBuilder();
        int a;
        while (n != 0) {
            a = n % 10;
            sb.append(a);
            n = n / 10;
        }
        return sb.toString();
    }

    /**
     * 用题解给的方法：直不管正负数，直接取模运算。
     * @param x
     * @return
     */
    /*public int reverse(int x) {
        // 储存结果
        int res = 0;
        while (x != 0) {

            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int temp = x % 10;
            // /=的好处：自动类型转换
            x /= 10;
            res = res * 10 + temp;
        }
        return res;
    }*/
}