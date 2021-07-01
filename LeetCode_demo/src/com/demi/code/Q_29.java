package com.demi.code;

/** 题目：两数相除
 *  题目描述：给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和mod运算符。
 *  返回被除数除以除数得到的商。
 *  整数除法的结果应当截去其小数部分。
 *
 *  示例 1：
 *      输入: dividend = 10, divisor = 3
 *      输出: 3
 *      解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 *  示例 2：
 *      输入: dividend = 7, divisor = -3
 *      输出: -2
 *      解释: 7/-3 = truncate(-2.33333..) = -2
 *
 */
public class Q_29 {
    public static void main(String[] args) {
        Q_29 qus = new Q_29();
        System.out.println(qus.divide(10, 2));
    }

    /**
     *  二分和倍增乘法
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        long x = dividend, y = divisor;
        boolean isNeg = false;
        if(x > 0 && y < 0 || (x < 0 && y > 0)) {
            isNeg = true;
        }
        if(x < 0) x = -x;
        if(y < 0) y = -y;
        long l = 0, r = x;
        while(l < r) {
            long mid = l + r + 1 >> 1;
            if(mul(mid, y) <= x) {
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        long ans = isNeg ? -1 : 1;
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return (int)ans;

    }

    private long mul(long a, long b) {
        long ans = 0;
        while (b > 0) {
            if((b & 1) == 1)
                ans += a;
            b >>= 1;
            a += a;
        }
        return ans;
    }
}
