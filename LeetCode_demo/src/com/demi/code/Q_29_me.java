package com.demi.code;

/**
 * 归类：其他
 * 题目：两数相除
 */
public class Q_29_me {
    public static void main(String[] args) {
        int dd = 10;
        int d = 5;
        int res = divide(dd, d);
        System.out.println(res);
    }

    /**
     * 递归的方式求解。
     * @param dividend
     * @param divisor
     * @return  商
     */
    public static int divide(int dividend, int divisor) {
        // 0除以任何数都为0
        if (dividend == 0) return 0;
        // 任何数除以1都为被除数本身
        if (divisor == 1) return dividend;
        // 越界情况的处理
        if (divisor == -1) {
            // 比最小负数大的被除数与-1做除法，得到的结果是被除数的相反数
            if (dividend > Integer.MIN_VALUE)
                return -dividend;
            // 反过来，比最小负数小的被除数与-1做除法，最大的救过就是最大整数，所以返回最大的整数值。
            return Integer.MAX_VALUE;
        }
        long a = dividend;
        long b = divisor;
        // 初始化正负号为整数(1为正数，-1为负数)
        int sign = 1;
        // 正负号的处理
        // 如果被除数和除数为一正一负的情况，最后的结果必然为负数。
        if ((a > 0 && b < 0) || (a < 0 && b > 0))
            sign = -1;
        // 正负数的处理
        // 为了好运算，之前已经对正负号做了处理，这里不管正负都按照整数，方便计算
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        int res = div(a, b);
        if (sign > 0)
            return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
        return res;
    }

    /**
     * 主要的处理就在这里：
     *    以11 / 3为例。11大于3是很明显看的出来的，
     *    首先将3翻倍（3 + 3）得到6，11比6还要大，将6再翻倍（6 + 6）得到12，11 < 12，
     *    可以判断11 / 3的结果在2~4之间。将第一次翻倍得到的6与被除数11做差值得到5（11 - 6 = 5），
     *    相对于5来说，可以看出5又是3的几倍呢？又是除法，递归函数出现了。
     *    就像这样循环的找商，直到翻倍后的结果等于或者小于被除数位置。
     * @param a
     * @param b
     * @return
     */
    private static int div(long a, long b) {
        if (a < b)
            return 0;
        long count = 1;
        long testb = b;
        while ((testb + b) <= a) {
            // 最小解翻倍
            count = count + count;
            // 测试值也翻倍
            testb = testb + testb;
        }
        return (int)count + div(a-testb, b);
    }
}
